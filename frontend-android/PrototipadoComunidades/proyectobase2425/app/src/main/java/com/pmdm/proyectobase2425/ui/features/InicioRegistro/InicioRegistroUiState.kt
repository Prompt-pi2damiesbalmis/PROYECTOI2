package com.pmdm.proyectobase2425.ui.features.InicioRegistro

data class InicioRegistroUiState (
    val email: String = "",
    val password: String = "",

    val username: String = "",
    val birthDate: String = "",
    val confirmPassword: String = "",

    val isLoading: Boolean = false,
    val error: String? = null,
    val isLoggedIn: Boolean = false
)