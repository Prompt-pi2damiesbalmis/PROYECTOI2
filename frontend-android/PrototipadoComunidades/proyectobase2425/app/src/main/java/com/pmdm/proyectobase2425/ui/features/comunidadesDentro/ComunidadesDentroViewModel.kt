package com.pmdm.proyectobase2425.ui.features.comunidadesDentro

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmdm.proyectobase2425.CommunityMode
import com.pmdm.proyectobase2425.data.repositories.ComunidadRepository
import com.pmdm.proyectobase2425.data.repositories.EventoRepository
import com.pmdm.proyectobase2425.data.services.ComunidadEntity
import com.pmdm.proyectobase2425.data.services.EventoEntity
import com.pmdm.proyectobase2425.models.Comunidad
import com.pmdm.proyectobase2425.models.Evento
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class ComunidadesDentroViewModel @Inject constructor(
    private val comunidadRepository: ComunidadRepository,
    private val eventoRepository: EventoRepository
) : ViewModel() {

    var state by mutableStateOf(ComunidadesDentroUiState())
        private set

    fun cargarComunidad(comunidadId: Long) {
        viewModelScope.launch {
            comunidadRepository.getById(comunidadId).collect { comunidadEntity ->
                if (comunidadEntity != null) {
                    val comunidad = Comunidad(
                        id = comunidadEntity.id,
                        nombre = comunidadEntity.nombre,
                        descripcion = comunidadEntity.descripcion,
                        imagen = comunidadEntity.imagen,
                        creadorId = comunidadEntity.creadorId
                    )
                    state = state.copy(
                        comunidad = comunidad,
                        esCreador = comunidadEntity.creadorId == 1L,
                        isLoading = false
                    )
                }
            }
        }
        // Cargar eventos
        viewModelScope.launch {
            eventoRepository.getByComunidad(comunidadId).collect { eventosEntity ->
                val eventos = eventosEntity.map { entity ->
                    Evento(
                        id = entity.id,
                        nombre = entity.nombre,
                        descripcion = entity.descripcion,
                        fechaHora = LocalDateTime.parse(entity.fechaHora), // Asumiendo formato ISO
                        ubicacion = entity.ubicacion,
                        imagen = entity.imagen,
                        estado = entity.estado
                    )
                }
                state = state.copy(eventos = eventos)
            }
        }
    }

    fun onEvent(event: ComunidadesDentroEvent) {
        when (event) {
            is ComunidadesDentroEvent.OnAddEventoClick ->
                state = state.copy(dialogMode = CommunityMode.CREATE)

            is ComunidadesDentroEvent.OnEditComunidadClick ->
                state = state.copy(dialogMode = CommunityMode.EDIT)

            is ComunidadesDentroEvent.OnDismissDialog ->
                state = state.copy(dialogMode = CommunityMode.NONE)

            is ComunidadesDentroEvent.OnConfirmEditComunidad -> {
                viewModelScope.launch {
                    val updatedEntity = ComunidadEntity(
                        id = state.comunidad?.id ?: 0L,
                        nombre = event.nombre,
                        descripcion = event.descripcion,
                        imagen = state.comunidad?.imagen ?: ""
                    )
                    comunidadRepository.upsert(updatedEntity)
                    state = state.copy(dialogMode = CommunityMode.NONE)
                }
            }

            is ComunidadesDentroEvent.OnCreateEvento -> {
                viewModelScope.launch {
                    val nuevoEventoEntity = EventoEntity(
                        id = 0L, // Auto-generate
                        nombre = event.nombre,
                        descripcion = event.descripcion,
                        fechaHora = event.fechaHora,
                        imagen = "",
                        estado = "Activo",
                        comunidadId = state.comunidad?.id ?: 0L
                    )
                    eventoRepository.upsert(nuevoEventoEntity)
                    state = state.copy(dialogMode = CommunityMode.NONE)
                }
            }
        }
    }
}
