package com.pmdm.proyectobase2425.ui.features.eventos

sealed interface EventosEvent {
    data class OnBusquedaChanged(val texto: String) : EventosEvent
    data class OnEventoClick(val eventoId: Long) : EventosEvent
}
