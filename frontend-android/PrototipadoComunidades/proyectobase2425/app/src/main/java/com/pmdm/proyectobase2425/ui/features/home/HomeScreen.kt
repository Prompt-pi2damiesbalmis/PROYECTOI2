package com.pmdm.proyectobase2425.ui.theme.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pmdm.proyectobase2425.R
import com.pmdm.proyectobase2425.ui.theme.features.comunidades.ComunidadesScreen
import com.pmdm.proyectobase2425.ui.theme.GreenBar
import com.pmdm.proyectobase2425.ui.theme.ProyectoBase2425Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(homeEvent: (HomeEvent) -> Unit) {

    val navController = rememberNavController()

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Scaffold(
            topBar = { TopBar(onEvent = homeEvent) },
            bottomBar = { BottomBar(onEvent = { homeEvent }) },
            containerColor = Color.Transparent
        ) { paddingValues ->

            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = Modifier.padding(paddingValues)
            ) {
                composable("home") { /*HomeScreenContent()*/ }
                composable("comunidad") { ComunidadesScreen(homeEvent) }
                composable("tienda") { /*TiendaScreen()*/ }
            }
        }
    }
}

private fun handleHomeEvent(event: HomeEvent, navController: NavHostController) {
        when (event) {
        HomeEvent.GoHome -> navController.navigate("home")
        HomeEvent.GoComunidad -> navController.navigate("comunidad")
        HomeEvent.GoTienda -> navController.navigate("tienda")
        HomeEvent.OpenPerfil -> navController.navigate("perfil")
        HomeEvent.OpenSettings -> navController.navigate("settings")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(onEvent: (HomeEvent) -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = GreenBar,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = { onEvent(HomeEvent.OpenPerfil)}) {
                Icon(Icons.Filled.Person, contentDescription = "Perfil")
            }
        },
        title = { },
        actions = {
            IconButton(onClick = { onEvent(HomeEvent.OpenSettings) }) {
                Icon(Icons.Filled.Settings, contentDescription = "Ajustes")
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(onEvent: (HomeEvent) -> Unit) {
    BottomAppBar(
        containerColor = GreenBar,
        contentColor = Color.White
    ) {
        IconButton(
            onClick = { onEvent(HomeEvent.GoHome) },
            modifier = Modifier.weight(1f)
        ) {
            Icon(Icons.Filled.Home, contentDescription = "Home")
        }

        IconButton(
            onClick = { onEvent(HomeEvent.GoComunidad) },
            modifier = Modifier.weight(1f)
        ) {
            Icon(Icons.Filled.List, contentDescription = "Comunidad")
        }

        IconButton(
            onClick = { onEvent(HomeEvent.GoTienda) },
            modifier = Modifier.weight(1f)
        ) {
            Icon(Icons.Filled.ShoppingCart, contentDescription = "Tienda")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ProyectoBase2425Theme {
        HomeScreen{}
    }
}
