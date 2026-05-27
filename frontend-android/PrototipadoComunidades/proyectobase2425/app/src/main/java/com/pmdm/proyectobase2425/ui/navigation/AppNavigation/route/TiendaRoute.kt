package com.pmdm.proyectobase2425.ui.navigation.AppNavigation.route

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.pmdm.proyectobase2425.ui.features.tienda.TiendaScreen
import com.pmdm.proyectobase2425.ui.features.tienda.TiendaViewModel
import kotlinx.serialization.Serializable

@Serializable
object TiendaRoute

fun NavGraphBuilder.tiendaDestination(
    navController: NavHostController
) {
    composable<TiendaRoute> {
        val vm: TiendaViewModel = hiltViewModel()
        TiendaScreen(
            uiState = vm.state,
            onEvent = { event -> vm.onEvent(event) }
        )
    }
}
