package com.pmdm.proyectobase2425.ui.navigation.AppNavigation.route

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
data class EventoRoute(val eventoId: Long)

fun NavGraphBuilder.eventoDestination(
    navController: NavHostController
) {
    composable<EventoRoute> { backStackEntry ->
        val route = backStackEntry.toRoute<EventoRoute>()
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Evento ${route.eventoId} — próximamente")
        }
    }
}