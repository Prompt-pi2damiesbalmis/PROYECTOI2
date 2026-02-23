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
import com.pmdm.proyectobase2425.ui.theme.features.home.BottomBar
import com.pmdm.proyectobase2425.ui.theme.features.home.TopBar
import com.pmdm.proyectobase2425.ui.theme.features.home.HomeEvent
import com.pmdm.proyectobase2425.ui.theme.GreenBar
import com.pmdm.proyectobase2425.ui.theme.ProyectoBase2425Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComunidadesScreen(
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
                    modifier = Modifier.weight(1f)
                )
            }

            AddComunidadesButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 20.dp, bottom = 90.dp),
                onClick = {
                    mode = CommunityMode.CREATE
                }
            )
        }

        if (mode == CommunityMode.CREATE) {
            CrearComunidadDialog(
                onDismiss = {
                    mode = CommunityMode.NONE
                },
                onConfirm = {
                    mode = CommunityMode.NONE
                }
            )
        }
    }
}

@Composable
fun CrearComunidadDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    var nombre by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(
                onClick = {
                    onConfirm()
                }
            ) {
                Text("Crear comunidad")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        },
        title = {
            Text(
                text = "Creador de comunidad",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre de la comunidad") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = descripcion,
                    onValueChange = { descripcion = it },
                    label = { Text("Descripción") },
                    modifier = Modifier.fillMaxWidth(),
                    minLines = 3
                )

                Button(
                    onClick = { /* selector de imagen más adelante */ },
                    modifier = Modifier.align(Alignment.Start)
                ) {
                    Text("Seleccionar foto")
                }
            }
        }
    )
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

@Composable
fun ComunidadesGrid(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            ComunidadCard(
                title = "Todos unidos",
                imageRes = R.drawable.comunidad2
            )
        }

        item {
            ComunidadCard(
                title = "Por el planeta",
                imageRes = R.drawable.mundo
            )
        }

        item {
            ComunidadCard(
                title = "Eco Acción",
                imageRes = R.drawable.comunidad3
            )
        }

        item {
            ComunidadCard(
                title = "Tribu verde",
                imageRes = R.drawable.comunidad4
            )
        }

        item {
            ComunidadCard(
                title = "Olas limpias",
                imageRes = R.drawable.comunidad5
            )
        }

        item {
            ComunidadCard(
                title = "Eco Tech",
                imageRes = R.drawable.comunidad6
            )
        }
    }
}


@Composable
fun ComunidadCard(
    title: String,
    imageRes: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComunidadesScreenPreview() {
    ProyectoBase2425Theme {
        ComunidadesScreen(onHomeEvent = {})
    }
}
