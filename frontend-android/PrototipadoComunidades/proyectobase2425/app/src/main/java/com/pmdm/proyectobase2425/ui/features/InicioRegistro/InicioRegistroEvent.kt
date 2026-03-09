package com.pmdm.proyectobase2425.ui.features.InicioRegistro

sealed interface InicioRegistroEvent {
    data class OnEmailChanged(val email: String) : InicioRegistroEvent

    data class OnPasswordChanged(val password: String) : InicioRegistroEvent

    object OnLoginClicked : InicioRegistroEvent

    data class OnUsernameChanged(val username: String) : InicioRegistroEvent

    data class OnBirthDateChanged(val birthDate: String) : InicioRegistroEvent

    data class OnConfirmPasswordChanged(val confirmPassword: String) : InicioRegistroEvent

    object OnRegisterClicked : InicioRegistroEvent
}