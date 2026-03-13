package com.pmdm.proyectobase2425.ui.navigation.AppNavigation.route

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.pmdm.proyectobase2425.ui.features.home.HomeMainScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

fun NavGraphBuilder.homeDestination(
    navController: NavHostController
) {
    composable<HomeRoute> {
        HomeMainScreen()
    }
}