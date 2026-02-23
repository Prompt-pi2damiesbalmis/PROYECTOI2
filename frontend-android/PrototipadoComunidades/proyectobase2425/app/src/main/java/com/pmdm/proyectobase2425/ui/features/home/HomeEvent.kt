package com.pmdm.proyectobase2425.ui.theme.features.home

sealed interface HomeEvent {
    object GoHome : HomeEvent
    object GoComunidad : HomeEvent
    object GoTienda : HomeEvent
    object OpenPerfil : HomeEvent
    object OpenSettings : HomeEvent
}
