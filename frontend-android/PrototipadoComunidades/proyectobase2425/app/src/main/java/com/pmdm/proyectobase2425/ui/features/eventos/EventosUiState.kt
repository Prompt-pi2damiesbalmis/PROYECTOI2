package com.pmdm.proyectobase2425.ui.features.eventos

import com.pmdm.proyectobase2425.models.Evento

data class EventosUiState(
    val eventos: List<Evento> = emptyList(),
    val eventosFiltrados: List<Evento> = emptyList(),
    val textoBusqueda: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)
