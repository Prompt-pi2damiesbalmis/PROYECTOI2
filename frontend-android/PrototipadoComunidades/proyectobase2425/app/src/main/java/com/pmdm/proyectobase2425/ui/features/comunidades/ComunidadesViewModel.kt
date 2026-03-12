package com.pmdm.proyectobase2425.ui.features.comunidades

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pmdm.proyectobase2425.CommunityMode
import com.pmdm.proyectobase2425.models.Comunidad
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ComunidadesViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(ComunidadesUiState())
        private set

    init {
        cargarComunidades()
    }

    fun onEvent(event: ComunidadesEvent) {
        when (event) {
            is ComunidadesEvent.OnAddComunidadClick -> onAddComunidadClick()
            is ComunidadesEvent.OnDismissDialog -> onDismissDialog()
            is ComunidadesEvent.OnCreateComunidad -> onCreateComunidad(event.nombre, event.descripcion)
            is ComunidadesEvent.OnComunidadClick -> { /* Interceptado en el destination */ }
        }
    }

    private fun cargarComunidades() {
        state = state.copy(isLoading = true)
        // TODO: llamada al repositorio
        state = state.copy(isLoading = false, comunidades = emptyList())
    }

    private fun onAddComunidadClick() {
        state = state.copy(dialogMode = CommunityMode.CREATE)
    }

    private fun onDismissDialog() {
        state = state.copy(dialogMode = CommunityMode.NONE)
    }

    private fun onCreateComunidad(nombre: String, descripcion: String) {
        if (nombre.isBlank() || descripcion.isBlank()) {
            state = state.copy(error = "El nombre y la descripción no pueden estar vacíos")
            return
        }

        val nuevaComunidad = Comunidad(
            comunidadId = (state.comunidades.maxOfOrNull { it.comunidadId } ?: 0) + 1,
            nombre = nombre,
            imagen = "",
            descripcion = descripcion
        )

        state = state.copy(
            comunidades = state.comunidades + nuevaComunidad,
            dialogMode = CommunityMode.NONE,
            error = null
        )
    }
}