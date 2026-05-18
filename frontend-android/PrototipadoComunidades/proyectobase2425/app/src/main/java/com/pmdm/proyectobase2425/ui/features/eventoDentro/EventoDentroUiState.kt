package com.pmdm.proyectobase2425.ui.features.eventoDentro

import com.pmdm.proyectobase2425.models.Evento

data class EventoDentroUiState(
    val evento: Evento? = null,
    val inscrito: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null
)
