package com.pmdm.proyectobase2425.ui.theme.features.comunidades

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pmdm.proyectobase2425.CommunityMode
import com.pmdm.proyectobase2425.R
import com.pmdm.proyectobase2425.ui.theme.features.home.BottomBar
import com.pmdm.proyectobase2425.ui.theme.features.home.HomeEvent
import com.pmdm.proyectobase2425.ui.theme.features.home.TopBar
import com.pmdm.proyectobase2425.ui.theme.GreenBar
import com.pmdm.proyectobase2425.ui.theme.ProyectoBase2425Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComunidadesDentroScreen(
    navController: NavHostController,
    onHomeEvent: (HomeEvent) -> Unit
) {
    var menuExpanded by remember { mutableStateOf(false) }
    var dialogMode by remember { mutableStateOf(CommunityMode.NONE) }

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

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 24.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Todos Unidos",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2E2E2E)
                        )

                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray.copy(alpha = 0.5f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.iconoeco),
                                modifier = Modifier.size(40.dp),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                        }
                    }

                    Text(
                        text = "Somos la Comunidad Eco-Conexión, y ¡acabamos de aterrizar en esta aplicación!",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF004D40),
                        lineHeight = 24.sp,
                        modifier = Modifier.padding(bottom = 24.dp)
                    )

                    Text(
                        text = "Lista eventos",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    )

                    Card(
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 120.dp)
                    ) {
                        Column {
                            Image(
                                painter = painterResource(id = R.drawable.playa),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(180.dp),
                                contentScale = ContentScale.Crop
                            )

                            Text(
                                text = "Tras 12 horas de trabajo en la limpieza de las playas...",
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }

                // FAB + menú
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 20.dp, bottom = 90.dp)
                ) {
                    FloatingActionButton(
                        onClick = { menuExpanded = true },
                        containerColor = Color.White,
                        contentColor = GreenBar
                    ) {
                        Icon(Icons.Filled.Add, contentDescription = null)
                    }

                    DropdownMenu(
                        expanded = menuExpanded,
                        onDismissRequest = { menuExpanded = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Crear comunidad") },
                            onClick = {
                                menuExpanded = false
                                dialogMode = CommunityMode.CREATE
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Editar comunidad") },
                            onClick = {
                                menuExpanded = false
                                dialogMode = CommunityMode.EDIT
                            }
                        )
                    }
                }
            }
        }

        // 👉 DIÁLOGOS
        if (dialogMode == CommunityMode.CREATE) {
            CrearComunidadDialog(
                onConfirm = {  },
                onDismiss = { dialogMode = CommunityMode.NONE }
            )
        }

        if (dialogMode == CommunityMode.EDIT) {
            CrearComunidadDialog(
                onConfirm = {  },
                onDismiss = { dialogMode = CommunityMode.NONE }
            )
        }
    }
}

@Composable
fun EditarComunidadDialog(
    nombreInicial: String,
    descripcionInicial: String,
    onDismiss: () -> Unit,
    onConfirm: (String, String) -> Unit
) {
    var nombre by remember { mutableStateOf(nombreInicial) }
    var descripcion by remember { mutableStateOf(descripcionInicial) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "Editar comunidad",
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
                    onClick = { /* cambiar imagen más adelante */ },
                    modifier = Modifier.align(Alignment.Start)
                ) {
                    Text("Cambiar foto")
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    onConfirm(nombre, descripcion)
                }
            ) {
                Text("Guardar cambios")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}




@Preview(showBackground = true)
@Composable
fun ComunidadesDentroScreenPreview() {
    ProyectoBase2425Theme {
        ComunidadesDentroScreen(
            navController = rememberNavController(),
            onHomeEvent = {}
        )
    }
}

