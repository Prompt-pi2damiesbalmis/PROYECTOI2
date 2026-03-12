package com.pmdm.proyectobase2425.ui.features.perfil

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmdm.proyectobase2425.models.Comunidad
import com.pmdm.proyectobase2425.models.Evento
import com.pmdm.proyectobase2425.models.Usuario
import com.pmdm.proyectobase2425.ui.theme.GreenBar
import com.pmdm.proyectobase2425.ui.theme.ProyectoBase2425Theme
import com.pmdm.proyectobase2425.ui.theme.greenPrimary
import java.time.LocalDateTime

@Composable
fun PerfilScreen(
    uiState: PerfilUiState,
    onEvent: (PerfilEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        // Avatar
        Box(
            modifier = Modifier
                .size(110.dp)
                .clip(CircleShape)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = uiState.usuario.nombreUsuario.take(1).uppercase(),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Nombre completo
        Text(
            text = "${uiState.usuario.nombre} ${uiState.usuario.apellidos}",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2E2E2E)
        )

        // Nombre de usuario
        Text(
            text = "@${uiState.usuario.nombreUsuario}",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botón Comunidades
        ToggleListButton(
            label = "Comunidades",
            expanded = uiState.showComunidades,
            onClick = { onEvent(PerfilEvent.OnToggleComunidades) }
        )

        AnimatedVisibility(visible = uiState.showComunidades) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (uiState.comunidades.isEmpty()) {
                    Text(
                        text = "No perteneces a ninguna comunidad",
                        color = Color.Gray,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                } else {
                    uiState.comunidades.forEach { comunidad ->
                        ComunidadItem(comunidad = comunidad)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Botón Eventos
        ToggleListButton(
            label = "Eventos",
            expanded = uiState.showEventos,
            onClick = { onEvent(PerfilEvent.OnToggleEventos) }
        )

        AnimatedVisibility(visible = uiState.showEventos) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (uiState.eventos.isEmpty()) {
                    Text(
                        text = "No participas en ningún evento",
                        color = Color.Gray,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                } else {
                    uiState.eventos.forEach { evento ->
                        EventoItem(evento = evento)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun ToggleListButton(
    label: String,
    expanded: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = GreenBar)
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Composable
private fun ComunidadItem(comunidad: Comunidad) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(greenPrimary.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = comunidad.nombre.take(1).uppercase(),
                    fontWeight = FontWeight.Bold,
                    color = greenPrimary
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = comunidad.nombre,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp
                )
                Text(
                    text = comunidad.descripcion,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    maxLines = 1
                )
            }
        }
    }
}

@Composable
private fun EventoItem(evento: Evento) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(GreenBar.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = evento.fecha.dayOfMonth.toString(),
                    fontWeight = FontWeight.Bold,
                    color = GreenBar,
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = evento.nombre,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp
                )
                Text(
                    text = evento.ubicacion,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    maxLines = 1
                )
            }
        }
    }
}

// ─── Preview ───
@Preview(showBackground = true, name = "PerfilScreen - vacío")
@Composable
fun PerfilScreenPreview() {
    ProyectoBase2425Theme {
        PerfilScreen(
            uiState = PerfilUiState(
                usuario = Usuario(
                    usuarioId = 1,
                    contraseña = "",
                    admin = false,
                    nombreUsuario = "manolo67",
                    nombre = "Manolo",
                    apellidos = "Martinez Alvarez",
                    correo = "manolo@email.com",
                    imagen = "",
                    descripcion = "",
                    edad = LocalDateTime.now(),
                    puntos = 120,
                    puntosExperiencia = 70
                )
            ),
            onEvent = {}
        )
    }
}

@Preview(showBackground = true, name = "PerfilScreen - comunidades desplegadas")
@Composable
fun PerfilScreenComunidadesPreview() {
    ProyectoBase2425Theme {
        PerfilScreen(
            uiState = PerfilUiState(
                usuario = Usuario(
                    usuarioId = 1,
                    contraseña = "",
                    admin = false,
                    nombreUsuario = "manolo67",
                    nombre = "Manolo",
                    apellidos = "Martinez Alvarez",
                    correo = "manolo@email.com",
                    imagen = "",
                    descripcion = "",
                    edad = LocalDateTime.now(),
                    puntos = 120,
                    puntosExperiencia = 70
                ),
                showComunidades = true,
                comunidades = listOf(
                    Comunidad(1, "EcoValencia", "", "Sostenibilidad en Valencia", Rol()),
                    Comunidad(2, "Madrid Sostenible", "", "Iniciativas en Madrid", Rol())
                )
            ),
            onEvent = {}
        )
    }
}

@Preview(showBackground = true, name = "PerfilScreen - eventos desplegados")
@Composable
fun PerfilScreenEventosPreview() {
    ProyectoBase2425Theme {
        PerfilScreen(
            uiState = PerfilUiState(
                usuario = Usuario(
                    usuarioId = 1,
                    contraseña = "",
                    admin = false,
                    nombreUsuario = "manolo67",
                    nombre = "Manolo",
                    apellidos = "Martinez Alvarez",
                    correo = "manolo@email.com",
                    imagen = "",
                    descripcion = "",
                    edad = LocalDateTime.now(),
                    puntos = 120,
                    puntosExperiencia = 70
                ),
                showEventos = true,
                eventos = listOf(
                    Evento(1, "Limpieza playa", "Valencia", "Limpieza de residuos", "", LocalDateTime.now()),
                    Evento(2, "Plantación árboles", "Madrid", "Reforestación urbana", "", LocalDateTime.now())
                )
            ),
            onEvent = {}
        )
    }
}
