package com.pmdm.proyectobase2425.ui.features.eventoDentro

sealed interface EventoDentroEvent {
    object OnInscribirse : EventoDentroEvent
    object OnDesinscribirse : EventoDentroEvent
}
