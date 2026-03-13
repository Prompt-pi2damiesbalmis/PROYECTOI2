package com.pmdm.proyectobase2425.ui.navigation.AppNavigation.route

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.pmdm.proyectobase2425.ui.features.perfil.PerfilScreen
import com.pmdm.proyectobase2425.ui.features.perfil.PerfilViewModel
import kotlinx.serialization.Serializable

@Serializable
object PerfilRoute

fun NavGraphBuilder.perfilDestination(
    navController: NavHostController
) {
    composable<PerfilRoute> {
        val vm: PerfilViewModel = hiltViewModel()
        PerfilScreen(
            uiState = vm.state,
            onEvent = { event -> vm.onEvent(event) }
        )
    }
}