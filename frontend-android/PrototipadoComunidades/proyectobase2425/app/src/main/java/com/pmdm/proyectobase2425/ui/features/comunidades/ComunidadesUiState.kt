package com.pmdm.proyectobase2425.ui.features.comunidades

import com.pmdm.proyectobase2425.CommunityMode
import com.pmdm.proyectobase2425.models.Comunidad

data class ComunidadesUiState(
    val comunidades: List<Comunidad> = emptyList(),
    val dialogMode: CommunityMode = CommunityMode.NONE,
    val isLoading: Boolean = false,
    val error: String? = null
)