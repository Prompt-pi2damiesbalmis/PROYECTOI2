package com.pmdm.proyectobase2425.ui.theme.features.comunidades

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmdm.proyectobase2425.CommunityMode
import com.pmdm.proyectobase2425.R
import com.pmdm.proyectobase2425.models.Comunidad
import com.pmdm.proyectobase2425.models.Rol
import com.pmdm.proyectobase2425.ui.features.comunidades.ComunidadesEvent
import com.pmdm.proyectobase2425.ui.features.comunidades.ComunidadesGrid
import com.pmdm.proyectobase2425.ui.features.comunidades.ComunidadesUiState
import com.pmdm.proyectobase2425.ui.features.comunidades.dialogos.CrearComunidadDialog
import com.pmdm.proyectobase2425.ui.theme.features.home.BottomBar
import com.pmdm.proyectobase2425.ui.theme.features.home.TopBar
import com.pmdm.proyectobase2425.ui.theme.features.home.HomeEvent
import com.pmdm.proyectobase2425.ui.theme.GreenBar
import com.pmdm.proyectobase2425.ui.theme.ProyectoBase2425Theme
import com.pmdm.proyectobase2425.ui.theme.navigation.AppRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComunidadesScreen(
    uiState: ComunidadesUiState,
    onEvent: (ComunidadesEvent) -> Unit,
    onHomeEvent: (HomeEvent) -> Unit
) {
    var mode by remember { mutableStateOf(CommunityMode.NONE) }

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Scaffold(
            topBar = { TopBar(onEvent = onHomeEvent) },
            bottomBar = { BottomBar(onEvent = onHomeEvent) },
            containerColor = Color.Transparent
        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                Text(
                    text = "Comunidades",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2E2E2E),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                )

                ComunidadesGrid(
                    comunidades = uiState.comunidades,
                    onComunidadClick = {},
                    modifier = Modifier.weight(1f)
                )
            }

            AddComunidadesButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 20.dp, bottom = 90.dp),
                onClick = {
                    onEvent(ComunidadesEvent.OnAddComunidadClick)
                }
            )
        }

        if (uiState.dialogMode == CommunityMode.CREATE) {
            CrearComunidadDialog(
                onDismiss = {
                    onEvent(ComunidadesEvent.OnDismissDialog)
                },
                onConfirm = {
                    //onEvent(ComunidadesEvent.OnCreateComunidad)
                }
            )
        }
    }
}

@Composable
fun AddComunidadesButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier,
        containerColor = Color.White,
        contentColor = GreenBar,
        shape = CircleShape,
        elevation = FloatingActionButtonDefaults.elevation(6.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Añadir comunidad"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComunidadesScreenPreview() {
    val roles = listOf(
        Rol(1, "Admin"),
        Rol(2, "Editor"),
        Rol(3, "User"),
        Rol(4, "Guest")
    )
    val fakeState = ComunidadesUiState(
        dialogMode = CommunityMode.NONE,
        comunidades =  listOf(
            Comunidad(
                1,
                "EcoValencia",
                "valencia_eco.jpg",
                "Comunidad dedicada a la sostenibilidad en Valencia y alrededores.",
                roles[0],
                mutableListOf(),
                mutableListOf()
            ),
            Comunidad(
                2,
                "Madrid Sostenible",
                "madrid_sustainable.jpg",
                "Iniciativas ecológicas y sostenibles en la capital.",
                roles[1],
                mutableListOf(),
                mutableListOf()
            )),
        isLoading = false,
        error = null
    )

    ProyectoBase2425Theme {
        ComunidadesScreen(
            uiState = fakeState,
            onEvent = {},
            onHomeEvent = {}
        )
    }
}
