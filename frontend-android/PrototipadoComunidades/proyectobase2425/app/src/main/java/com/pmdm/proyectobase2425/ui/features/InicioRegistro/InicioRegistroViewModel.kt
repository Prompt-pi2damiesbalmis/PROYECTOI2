package com.pmdm.proyectobase2425.ui.features.InicioRegistro

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InicioRegistroViewModel @Inject constructor() : ViewModel() {

    var uiState =  mutableStateOf(InicioRegistroUiState())
        private set

    init {
        // Estado inicial si quieres hacer alguna carga inicial
    }

    fun onEvent(event: InicioRegistroEvent) {
        when (event) {

            is InicioRegistroEvent.OnEmailChanged -> {
                uiState.value = uiState.value.copy(
                    email = event.email
                )
            }

            is InicioRegistroEvent.OnPasswordChanged -> {
                uiState.value = uiState.value.copy(
                    password = event.password
                )
            }

            is InicioRegistroEvent.OnUsernameChanged -> {
                uiState.value = uiState.value.copy(
                    username = event.username
                )
            }

            is InicioRegistroEvent.OnBirthDateChanged -> {
                uiState.value = uiState.value.copy(
                    birthDate = event.birthDate
                )
            }

            is InicioRegistroEvent.OnConfirmPasswordChanged -> {
                uiState.value = uiState.value.copy(
                    confirmPassword = event.confirmPassword
                )
            }

            is InicioRegistroEvent.OnLoginClicked -> {
                login()
            }

            is InicioRegistroEvent.OnRegisterClicked -> {
                register()
            }

            is InicioRegistroEvent.OnGoToRegistro -> { /* NavHost lo intercepta */ }

            is InicioRegistroEvent.OnRegistroExitoso -> {
                uiState.value = InicioRegistroUiState()
            }

            is InicioRegistroEvent.OnNavigateToHomeConsumed -> {
                uiState.value = uiState.value.copy(navigateToHome = false)
            }
        }
    }

    private fun login() {

        uiState.value = uiState.value.copy(
            isLoading = true,
            error = null
        )

        // Aquí iría la llamada a Firebase / API

        uiState.value = uiState.value.copy(
            isLoading = false,
            isLoggedIn = true,
            navigateToHome = true
        )
    }

    private fun register() {

        if (uiState.value.password != uiState.value.confirmPassword) {
            uiState.value = uiState.value.copy(
                error = "Las contraseñas no coinciden"
            )
            return
        }

        uiState.value = uiState.value.copy(
            isLoading = true,
            error = null
        )

        // Aquí iría Firebase / API

        uiState.value = uiState.value.copy(
            isLoading = false,
            isLoggedIn = false
        )
        onEvent(InicioRegistroEvent.OnRegistroExitoso)
    }
}