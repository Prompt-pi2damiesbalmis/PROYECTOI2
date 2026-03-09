package com.pmdm.proyectobase2425.ui.features.comunidades

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pmdm.proyectobase2425.CommunityMode
import com.pmdm.proyectobase2425.models.Comunidad
import com.pmdm.proyectobase2425.models.Rol

class ComunidadesViewModel : ViewModel() {

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
            is ComunidadesEvent.OnComunidadClick -> onComunidadClick(event.comunidadId)
            is ComunidadesEvent.OnEditComunidadClick -> onEditComunidadClick()
            is ComunidadesEvent.OnConfirmEditComunidad -> onConfirmEditComunidad(event.nombre, event.descripcion)
        }
    }

    private fun cargarComunidades() {
        state = state.copy(isLoading = true)
        // Aquí irá tu llamada al repositorio cuando lo tengas
        // Por ahora carga vacío
        state = state.copy(
            isLoading = false,
            comunidades = emptyList()
        )
    }

    private fun onAddComunidadClick() {
        state = state.copy(dialogMode = CommunityMode.CREATE)
    }

    private fun onDismissDialog() {
        state = state.copy(
            dialogMode = CommunityMode.NONE,
            comunidadSeleccionada = null
        )
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
            descripcion = descripcion,
            rol = Rol()
        )

        state = state.copy(
            comunidades = state.comunidades + nuevaComunidad,
            dialogMode = CommunityMode.NONE,
            error = null
        )
    }

    private fun onComunidadClick(comunidadId: Int) {
        val comunidad = state.comunidades.find { it.comunidadId == comunidadId }
        state = state.copy(comunidadSeleccionada = comunidad)
    }

    private fun onEditComunidadClick() {
        if (state.comunidadSeleccionada == null) {
            state = state.copy(error = "No hay ninguna comunidad seleccionada")
            return
        }
        state = state.copy(dialogMode = CommunityMode.EDIT)
    }

    private fun onConfirmEditComunidad(nombre: String, descripcion: String) {
        if (nombre.isBlank() || descripcion.isBlank()) {
            state = state.copy(error = "El nombre y la descripción no pueden estar vacíos")
            return
        }

        val comunidadEditada = state.comunidadSeleccionada?.copy(
            nombre = nombre,
            descripcion = descripcion
        ) ?: return

        state = state.copy(
            comunidades = state.comunidades.map {
                if (it.comunidadId == comunidadEditada.comunidadId) comunidadEditada else it
            },
            comunidadSeleccionada = null,
            dialogMode = CommunityMode.NONE,
            error = null
        )
    }
}