package com.pmdm.proyectobase2425.ui.features.home

data class HomeUiState(
    val currentRoute: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)