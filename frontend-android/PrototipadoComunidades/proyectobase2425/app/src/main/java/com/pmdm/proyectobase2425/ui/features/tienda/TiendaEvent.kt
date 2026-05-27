package com.pmdm.proyectobase2425.ui.features.tienda

sealed interface TiendaEvent {
    object OnCanjearClick : TiendaEvent
    data class OnProductoClick(val productoId: Long) : TiendaEvent
    object OnComoCunseguirPuntosClick : TiendaEvent
}
