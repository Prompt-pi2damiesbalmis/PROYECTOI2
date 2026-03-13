package com.pmdm.proyectobase2425

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.pmdm.proyectobase2425.ui.features.home.HomeScreen
import com.pmdm.proyectobase2425.ui.navigation.InicioRegistroNavigation.AuthNavHost
import com.pmdm.proyectobase2425.ui.theme.ProyectoBase2425Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoBase2425Theme {
                var isAuthenticated by remember { mutableStateOf(false) }

                if (isAuthenticated) {
                    HomeScreen(
                        onLogout = { isAuthenticated = false }
                    )
                } else {
                    val authNavController = rememberNavController()
                    AuthNavHost(
                        navController = authNavController,
                        onLoginSuccess = { isAuthenticated = true }
                    )
                }
            }
        }
    }
}



