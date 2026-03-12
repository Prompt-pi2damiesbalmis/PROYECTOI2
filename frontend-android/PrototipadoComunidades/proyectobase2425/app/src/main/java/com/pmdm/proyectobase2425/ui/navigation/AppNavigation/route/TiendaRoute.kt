package com.pmdm.proyectobase2425.ui.navigation.AppNavigation.route

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object TiendaRoute

fun NavGraphBuilder.tiendaDestination(
    navController: NavHostController
) {
    composable<TiendaRoute> {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Tienda — próximamente")
        }
    }
}