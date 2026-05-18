package com.pmdm.proyectobase2425.ui.features.eventos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmdm.proyectobase2425.data.repositories.EventoRepository
import com.pmdm.proyectobase2425.models.Evento
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class EventosViewModel @Inject constructor(
    private val eventoRepository: EventoRepository
) : ViewModel() {

    var state by mutableStateOf(EventosUiState())
        private set

    init {
        viewModelScope.launch {
            eventoRepository.getAll().collect { eventosEntity ->
                val eventos = eventosEntity.map { entity ->
                    Evento(
                        id = entity.id,
                        nombre = entity.nombre,
                        descripcion = entity.descripcion,
                        fechaHora = runCatching { LocalDateTime.parse(entity.fechaHora) }.getOrDefault(LocalDateTime.now()),
                        ubicacion = entity.ubicacion,
                        imagen = entity.imagen,
                        estado = entity.estado
                    )
                }
                state = state.copy(
                    eventos = eventos,
                    eventosFiltrados = filtrar(eventos, state.textoBusqueda),
                    isLoading = false
                )
            }
        }
    }

    fun onEvent(event: EventosEvent) {
        when (event) {
            is EventosEvent.OnBusquedaChanged -> {
                state = state.copy(
                    textoBusqueda = event.texto,
                    eventosFiltrados = filtrar(state.eventos, event.texto)
                )
            }
            is EventosEvent.OnEventoClick -> { /* Interceptado en el destination */ }
        }
    }

    private fun filtrar(eventos: List<Evento>, texto: String): List<Evento> {
        if (texto.isBlank()) return eventos
        return eventos.filter { it.nombre.contains(texto, ignoreCase = true) }
    }
}
