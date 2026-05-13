package com.pmdm.proyectobase2425.ui.features.comunidades

sealed interface ComunidadesDentroEvent {
    object OnAddEventoClick : ComunidadesDentroEvent
    object OnEditComunidadClick : ComunidadesDentroEvent
    object OnDismissDialog : ComunidadesDentroEvent
    data class OnConfirmEditComunidad(val nombre: String, val descripcion: String) : ComunidadesDentroEvent
    data class OnCreateEvento(val nombre: String, val descripcion: String, val fechaHora: String) : ComunidadesDentroEvent
}
