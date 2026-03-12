package com.pmdm.proyectobase2425.ui.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pmdm.proyectobase2425.R
import com.pmdm.proyectobase2425.ui.navigation.AppNavigation.route.AjustesRoute
import com.pmdm.proyectobase2425.ui.navigation.AppNavigation.route.ComunidadesRoute
import com.pmdm.proyectobase2425.ui.navigation.AppNavigation.route.HomeRoute
import com.pmdm.proyectobase2425.ui.navigation.AppNavigation.route.PerfilRoute
import com.pmdm.proyectobase2425.ui.navigation.AppNavigation.route.TiendaRoute
import com.pmdm.proyectobase2425.ui.theme.GreenBar
import com.pmdm.proyectobase2425.ui.theme.ProyectoBase2425Theme
import com.pmdm.proyectobase2425.ui.theme.navigation.AppNavHost

// ─── Composable real con ViewModel (usado en producción) ───
@Composable
fun HomeScreen(
    vm: HomeViewModel = hiltViewModel(),
    onLogout: () -> Unit
) {
    val navController = rememberNavController()
    HomeScreenContent(
        navController = navController,
        content = { AppNavHost(navController = navController, onLogout = onLogout) }
    )
}

// ─── Composable de contenido sin ViewModel ni NavHost (usado en preview) ───
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(
    navController: NavHostController,
    content: @Composable () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = GreenBar,
                        navigationIconContentColor = Color.White,
                        actionIconContentColor = Color.White,
                        titleContentColor = Color.White
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.navigate(PerfilRoute) {
                                launchSingleTop = true
                            }
                        }) {
                            Icon(Icons.Filled.Person, contentDescription = "Perfil")
                        }
                    },
                    title = { },
                    actions = {
                        IconButton(onClick = {
                            navController.navigate(AjustesRoute) {
                                launchSingleTop = true
                            }
                        }) {
                            Icon(Icons.Filled.Settings, contentDescription = "Ajustes")
                        }
                    }
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = GreenBar,
                    contentColor = Color.White
                ) {
                    IconButton(
                        onClick = {
                            navController.navigate(HomeRoute) {
                                popUpTo(HomeRoute) { inclusive = false }
                                launchSingleTop = true
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(Icons.Filled.Home, contentDescription = "Home")
                    }

                    IconButton(
                        onClick = {
                            navController.navigate(ComunidadesRoute) {
                                launchSingleTop = true
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(Icons.Filled.List, contentDescription = "Comunidad")
                    }

                    IconButton(
                        onClick = {
                            navController.navigate(TiendaRoute) {
                                launchSingleTop = true
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(Icons.Filled.ShoppingCart, contentDescription = "Tienda")
                    }
                }
            },
            containerColor = Color.Transparent
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                content()
            }
        }
    }
}

// ─── Pantalla principal de eventos (startDestination del AppNavHost) ───
@Composable
fun HomeMainScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text("Home — eventos")
    }
}

// ─── Preview: sin AppNavHost ni hiltViewModel, solo el Scaffold visual ───
@Preview(showBackground = true, name = "HomeScreen")
@Composable
fun HomeScreenPreview() {
    ProyectoBase2425Theme {
        HomeScreenContent(
            navController = rememberNavController(),
            content = {
                // Contenido fake para el preview
                Box(modifier = Modifier.fillMaxSize()) {
                    Text("Home — preview")
                }
            }
        )
    }
}
