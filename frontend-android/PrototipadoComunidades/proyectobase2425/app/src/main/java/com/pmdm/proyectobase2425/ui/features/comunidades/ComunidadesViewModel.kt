package com.pmdm.proyectobase2425.ui.features.comunidades

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmdm.proyectobase2425.CommunityMode
import com.pmdm.proyectobase2425.data.repositories.ComunidadRepository
import com.pmdm.proyectobase2425.models.Comunidad
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComunidadesViewModel @Inject constructor(
    private val comunidadRepository: ComunidadRepository
) : ViewModel() {

    var state by mutableStateOf(ComunidadesUiState())
        private set

    init {
        viewModelScope.launch {
            comunidadRepository.getAll().collect { comunidadesEntity ->
                val comunidades = comunidadesEntity.map { entity ->
                    Comunidad(
                        id = entity.id,
                        nombre = entity.nombre,
                        descripcion = entity.descripcion,
                        imagen = entity.imagen
                        // eventos y usuarios se cargarían por separado si fuera necesario
                    )
                }
                state = state.copy(comunidades = comunidades, isLoading = false)
            }
        }
    }

    fun onEvent(event: ComunidadesEvent) {
        when (event) {
            is ComunidadesEvent.OnAddComunidadClick -> onAddComunidadClick()
            is ComunidadesEvent.OnDismissDialog -> onDismissDialog()
            is ComunidadesEvent.OnCreateComunidad -> onCreateComunidad(event.nombre, event.descripcion)
            is ComunidadesEvent.OnComunidadClick -> { /* Interceptado en el destination */ }
        }
    }

    private fun cargarComunidades() {
        state = state.copy(isLoading = true)
        // TODO: llamada al repositorio
        state = state.copy(isLoading = false, comunidades = emptyList())
    }

    private fun onAddComunidadClick() {
        state = state.copy(dialogMode = CommunityMode.CREATE)
    }

    private fun onDismissDialog() {
        state = state.copy(dialogMode = CommunityMode.NONE)
    }

    private fun onCreateComunidad(nombre: String, descripcion: String) {
        if (nombre.isBlank() || descripcion.isBlank()) {
            state = state.copy(error = "El nombre y la descripción no pueden estar vacíos")
            return
        }

        viewModelScope.launch {
            val nuevaComunidadEntity = com.pmdm.proyectobase2425.data.services.ComunidadEntity(
                id = (state.comunidades.maxOfOrNull { it.id } ?: 0L) + 1L,
                nombre = nombre,
                descripcion = descripcion,
                imagen = ""
            )
            comunidadRepository.upsert(nuevaComunidadEntity)
            state = state.copy(dialogMode = CommunityMode.NONE, error = null)
        }
    }
}