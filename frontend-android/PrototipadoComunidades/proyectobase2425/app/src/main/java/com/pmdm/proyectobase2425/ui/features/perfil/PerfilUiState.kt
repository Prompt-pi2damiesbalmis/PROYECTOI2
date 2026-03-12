package com.pmdm.proyectobase2425.ui.features.perfil

import com.pmdm.proyectobase2425.models.Comunidad
import com.pmdm.proyectobase2425.models.Evento
import com.pmdm.proyectobase2425.models.Usuario

data class PerfilUiState(
    val usuario: Usuario = Usuario(),
    val comunidades: List<Comunidad> = emptyList(),
    val eventos: List<Evento> = emptyList(),
    val showComunidades: Boolean = false,
    val showEventos: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null
)
