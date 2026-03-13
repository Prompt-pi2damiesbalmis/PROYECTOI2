package com.pmdm.proyectobase2425.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.pmdm.proyectobase2425.ui.navigation.AppNavigation.route.HomeRoute
import com.pmdm.proyectobase2425.ui.navigation.AppNavigation.route.ajustesDestination
import com.pmdm.proyectobase2425.ui.navigation.AppNavigation.route.comunidadDentroDestination
import com.pmdm.proyectobase2425.ui.navigation.AppNavigation.route.comunidadesDestination
import com.pmdm.proyectobase2425.ui.navigation.AppNavigation.route.eventoDestination
import com.pmdm.proyectobase2425.ui.navigation.AppNavigation.route.homeDestination
import com.pmdm.proyectobase2425.ui.navigation.AppNavigation.route.perfilDestination
import com.pmdm.proyectobase2425.ui.navigation.AppNavigation.route.tiendaDestination

@Composable
fun AppNavHost(
    navController: NavHostController,
    onLogout: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {
        homeDestination(navController)
        comunidadesDestination(navController)
        comunidadDentroDestination(navController)
        tiendaDestination(navController)
        perfilDestination(navController)
        ajustesDestination(navController, onLogout)
        eventoDestination(navController)
    }
}

