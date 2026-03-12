package com.pmdm.proyectobase2425.ui.features.perfil

sealed interface PerfilEvent {
    object OnToggleComunidades : PerfilEvent
    object OnToggleEventos : PerfilEvent
}
