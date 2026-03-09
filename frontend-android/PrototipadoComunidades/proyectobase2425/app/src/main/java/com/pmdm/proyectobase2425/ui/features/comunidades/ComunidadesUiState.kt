package com.pmdm.proyectobase2425.ui.features.comunidades

import com.pmdm.proyectobase2425.CommunityMode
import com.pmdm.proyectobase2425.models.Comunidad

data class ComunidadesUiState(

    val dialogMode: CommunityMode = CommunityMode.NONE,

    val comunidades: List<Comunidad> = emptyList(),

    val comunidadSeleccionada: Comunidad? = null,

    val isLoading: Boolean = false,

    val error: String? = null
)