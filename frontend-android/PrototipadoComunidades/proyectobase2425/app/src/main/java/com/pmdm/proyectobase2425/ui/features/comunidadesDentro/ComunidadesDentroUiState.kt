package com.pmdm.proyectobase2425.ui.features.comunidades

import com.pmdm.proyectobase2425.CommunityMode
import com.pmdm.proyectobase2425.models.Comunidad

data class ComunidadesDentroUiState(
    val comunidad: Comunidad? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val dialogMode: CommunityMode = CommunityMode.NONE
)
