package com.pmdm.proyectobase2425.ui.navigation.AppNavigation.route

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.pmdm.proyectobase2425.ui.features.ajustes.AjustesScreen
import com.pmdm.proyectobase2425.ui.features.ajustes.AjustesViewModel
import kotlinx.serialization.Serializable

@Serializable
object AjustesRoute

fun NavGraphBuilder.ajustesDestination(
    navController: NavHostController,
    onLogout: () -> Unit
) {
    composable<AjustesRoute> {
        val vm: AjustesViewModel = hiltViewModel()
        AjustesScreen(
            uiState = vm.state,
            onEvent = { event -> vm.onEvent(event) },
            onLogout = onLogout
        )
    }
}