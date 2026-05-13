package com.pmdm.proyectobase.ui.features.comunidades

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmdm.proyectobase2425.CommunityMode
import com.pmdm.proyectobase2425.models.Comunidad
import com.pmdm.proyectobase2425.ui.features.comunidades.ComunidadesEvent
import com.pmdm.proyectobase2425.ui.features.comunidades.ComunidadesGrid
import com.pmdm.proyectobase2425.ui.features.comunidades.ComunidadesUiState
import com.pmdm.proyectobase2425.ui.features.comunidades.dialogos.CrearComunidadDialog
import com.pmdm.proyectobase2425.ui.theme.GreenBar
import com.pmdm.proyectobase2425.ui.theme.ProyectoBase2425Theme

@Composable
fun ComunidadesScreen(
    uiState: ComunidadesUiState,
    onEvent: (ComunidadesEvent) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxSize()) {

            Text(
                text = "Comunidades",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E2E2E),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
            )

            ComunidadesGrid(
                comunidades = uiState.comunidades,
                onComunidadClick = { comunidadId ->
                    onEvent(ComunidadesEvent.OnComunidadClick(comunidadId))
                },
                modifier = Modifier.weight(1f)
            )
        }

        // FAB añadir comunidad
        FloatingActionButton(
            onClick = { onEvent(ComunidadesEvent.OnAddComunidadClick) },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 20.dp, bottom = 16.dp),
            containerColor = Color.White,
            contentColor = GreenBar,
            shape = CircleShape
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Añadir comunidad")
        }

        // Diálogo crear comunidad
        if (uiState.dialogMode == CommunityMode.CREATE) {
            CrearComunidadDialog(
                onDismiss = { onEvent(ComunidadesEvent.OnDismissDialog) },
                onConfirm = { nombre, descripcion ->
                    onEvent(ComunidadesEvent.OnCreateComunidad(nombre, descripcion))
                }
            )
        }
    }
}

// ─── Previews ───
private val fakeComunidades = listOf(
    Comunidad(id = 1L, nombre = "EcoValencia", imagen = "", descripcion = "Comunidad dedicada a la sostenibilidad en Valencia."),
    Comunidad(id = 2L, nombre = "Madrid Sostenible", imagen = "", descripcion = "Iniciativas ecológicas en la capital."),
    Comunidad(id = 3L, nombre = "Barcelona Verde", imagen = "", descripcion = "Proyectos verdes en Barcelona."),
    Comunidad(id = 4L, nombre = "Sevilla Eco", imagen = "", descripcion = "Reciclaje y medio ambiente en Sevilla.")
)

@Preview(showBackground = true, name = "ComunidadesScreen - con comunidades")
@Composable
fun ComunidadesScreenPreview() {
    ProyectoBase2425Theme {
        ComunidadesScreen(
            uiState = ComunidadesUiState(comunidades = fakeComunidades),
            onEvent = { }
        )
    }
}

@Preview(showBackground = true, name = "ComunidadesScreen - vacía")
@Composable
fun ComunidadesScreenVaciaPreview() {
    ProyectoBase2425Theme {
        ComunidadesScreen(
            uiState = ComunidadesUiState(comunidades = emptyList()),
            onEvent = {}
        )
    }
}

@Preview(showBackground = true, name = "ComunidadesScreen - diálogo crear")
@Composable
fun ComunidadesScreenDialogoPreview() {
    ProyectoBase2425Theme {
        ComunidadesScreen(
            uiState = ComunidadesUiState(
                comunidades = fakeComunidades,
                dialogMode = CommunityMode.CREATE
            ),
            onEvent = {}
        )
    }
}