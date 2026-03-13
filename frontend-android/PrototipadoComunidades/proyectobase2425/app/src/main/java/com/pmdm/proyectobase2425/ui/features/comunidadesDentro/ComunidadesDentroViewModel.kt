package com.pmdm.proyectobase2425.ui.features.comunidades

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pmdm.proyectobase2425.CommunityMode
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ComunidadesDentroViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(ComunidadesDentroUiState())
        private set

    fun cargarComunidad(comunidadId: Long) {
        // TODO: cargar comunidad por ID desde repositorio
        state = state.copy(isLoading = false)
    }

    fun onEvent(event: ComunidadesDentroEvent) {
        when (event) {
            is ComunidadesDentroEvent.OnAddEventoClick ->
                state = state.copy(dialogMode = CommunityMode.CREATE)

            is ComunidadesDentroEvent.OnEditComunidadClick ->
                state = state.copy(dialogMode = CommunityMode.EDIT)

            is ComunidadesDentroEvent.OnDismissDialog ->
                state = state.copy(dialogMode = CommunityMode.NONE)

            is ComunidadesDentroEvent.OnConfirmEditComunidad -> {
                // TODO: actualizar comunidad en repositorio
                state = state.copy(dialogMode = CommunityMode.NONE)
            }

            is ComunidadesDentroEvent.OnCreateEvento -> {
                // TODO: crear evento en repositorio
                state = state.copy(dialogMode = CommunityMode.NONE)
            }
        }
    }
}
