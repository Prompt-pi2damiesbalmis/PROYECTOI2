package com.pmdm.proyectobase2425.ui.theme.navigation

import androidx.navigation.NavHostController
import com.pmdm.proyectobase2425.ui.theme.features.home.HomeEvent

fun handleHomeEvent(
    event: HomeEvent,
    navController: NavHostController
) {
    when (event) {

        HomeEvent.GoHome -> {
            navController.navigate(AppRoute.Home.route) {
                popUpTo(AppRoute.Home.route) { inclusive = true }
            }
        }

        HomeEvent.GoComunidad -> {
            navController.navigate(AppRoute.Comunidades.route)
        }

        // añade aquí más eventos si los tienes
        HomeEvent.GoTienda -> TODO()
        HomeEvent.OpenPerfil -> TODO()
        HomeEvent.OpenSettings -> TODO()
    }
}