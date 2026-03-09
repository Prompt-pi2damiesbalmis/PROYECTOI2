package com.pmdm.proyectobase2425.ui.features.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pmdm.proyectobase2425.ui.theme.features.home.HomeEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    var uiState by mutableStateOf(HomeUiState())
        private set
    init {
        onHomeEvent(HomeEvent.GoHome)
    }

    fun onHomeEvent(evento: HomeEvent) {
        when (evento) {
            is HomeEvent.GoHome -> {
                uiState = uiState.copy(currentRoute = "home")
            }

            is HomeEvent.GoComunidad -> {
                uiState = uiState.copy(currentRoute = "comunidad")
            }

            is HomeEvent.GoTienda -> {
                uiState = uiState.copy(currentRoute = "tienda")
            }

            is HomeEvent.OpenPerfil -> {
                uiState = uiState.copy(currentRoute = "perfil")
            }

            is HomeEvent.OpenSettings -> {
                uiState = uiState.copy(currentRoute = "settings")
            }
        }
    }
}