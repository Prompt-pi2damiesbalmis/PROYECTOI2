package com.pmdm.proyectobase2425.ui.features.comunidadesDentro

import com.pmdm.proyectobase2425.CommunityMode
import com.pmdm.proyectobase2425.models.Comunidad
import com.pmdm.proyectobase2425.models.Evento

data class ComunidadesDentroUiState(
    val comunidad: Comunidad? = null,
    val eventos: List<Evento> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val dialogMode: CommunityMode = CommunityMode.NONE
)
