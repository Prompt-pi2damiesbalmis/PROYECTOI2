package com.pmdm.proyectobase2425.ui.features.perfil

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PerfilViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(PerfilUiState())
        private set

    init {
        cargarPerfil()
    }

    fun onEvent(event: PerfilEvent) {
        when (event) {
            is PerfilEvent.OnToggleComunidades -> {
                state = state.copy(
                    showComunidades = !state.showComunidades,
                    showEventos = false
                )
            }
            is PerfilEvent.OnToggleEventos -> {
                state = state.copy(
                    showEventos = !state.showEventos,
                    showComunidades = false
                )
            }
        }
    }

    private fun cargarPerfil() {
        // TODO: cargar usuario, comunidades y eventos desde repositorio
        state = state.copy(isLoading = false)
    }
}
