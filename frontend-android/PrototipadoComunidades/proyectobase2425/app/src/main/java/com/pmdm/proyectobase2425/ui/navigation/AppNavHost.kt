package com.pmdm.proyectobase2425.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pmdm.proyectobase2425.ui.theme.features.comunidades.ComunidadesScreen
import com.pmdm.proyectobase2425.ui.theme.features.home.HomeScreen

sealed class AppRoute(val route: String) {
    object Home : AppRoute("home")
    object Comunidades : AppRoute("comunidades")
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = AppRoute.Home.route,
        modifier = modifier
    ) {

        composable(AppRoute.Home.route) {
            HomeScreen( {})
        }

        composable(AppRoute.Comunidades.route) {
            ComunidadesScreen(
                onHomeEvent = {}
            )
        }
    }
}

