package com.pmdm.proyectobase2425.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pmdm.proyectobase2425.features.InicioSesionScreen
import com.pmdm.proyectobase2425.ui.features.InicioRegistro.InicioRegistroViewModel

/*@Composable
fun InicioSesionRoute(
    viewModel: InicioRegistroViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    InicioSesionScreen(
        uiState = uiState,
        onEvent = viewModel::onEvent
    )
}*/