package com.pmdm.proyectobase2425.ui.navigation.AppNavigation.route

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.pmdm.proyectobase2425.ui.features.comunidades.ComunidadesDentroScreen
import com.pmdm.proyectobase2425.ui.features.comunidades.ComunidadesDentroViewModel
import kotlinx.serialization.Serializable

@Serializable
data class ComunidadDentroRoute(val comunidadId: Int)

fun NavGraphBuilder.comunidadDentroDestination(
    navController: NavHostController
) {
    composable<ComunidadDentroRoute> { backStackEntry ->
        val route = backStackEntry.toRoute<ComunidadDentroRoute>()
        val vm: ComunidadesDentroViewModel = hiltViewModel()

         ComunidadesDentroScreen(
            comunidadId = route.comunidadId.toLong(),
            uiState = vm.state,
            onEvent = { event -> vm.onEvent(event) },
            onNavigateToEvento = { eventoId ->
                navController.navigate(EventoRoute(eventoId))
            }
        )
    }
}