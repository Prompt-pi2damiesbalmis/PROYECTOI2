---
marp: true
theme: default
paginate: true
html: true
style: |
  * { box-sizing: border-box; }

  section {
    font-family: "Segoe UI", Arial, sans-serif;
    background: #ffffff;
    color: #1a1a1a;
    padding: 36px 50px;
    font-size: 20px;
  }
  section::after { color: #bbb; font-size: 0.62em; }

  h1 {
    color: #1B5E20;
    font-size: 1.65em;
    border-bottom: 4px solid #2E7D32;
    padding-bottom: 8px;
    margin: 0 0 20px;
  }
  h2 { color: #2E7D32; font-size: 1.1em; margin: 12px 0 6px; }
  h3 { color: #388E3C; font-size: 0.95em; margin: 8px 0 4px; }

  ul { margin: 0 0 0 1.2em; line-height: 1.85; }
  li { font-size: 0.84em; }

  code {
    background: #F1F8E9; color: #1B5E20;
    border-radius: 4px; padding: 1px 6px; font-size: 0.78em;
  }
  pre {
    background: #F8FBF8;
    border-left: 5px solid #43A047;
    border-radius: 6px;
    padding: 12px 16px;
    font-size: 0.68em;
    line-height: 1.5;
    margin: 6px 0;
  }
  pre code { background: none; color: #1a1a1a; padding: 0; font-size: 1em; }

  .cols2 { display: grid; grid-template-columns: 1fr 1fr; gap: 24px; align-items: start; }
  .cols3 { display: grid; grid-template-columns: 1fr 1fr 1fr; gap: 16px; align-items: start; }
  .cols4 { display: grid; grid-template-columns: 1fr 1fr 1fr 1fr; gap: 12px; align-items: start; }
  .center { text-align: center; }
  .caption { text-align: center; font-size: 0.72em; color: #666; margin-top: 6px; }

  .card {
    background: #F1F8E9; border-left: 5px solid #4CAF50;
    border-radius: 8px; padding: 12px 16px; margin-bottom: 8px; font-size: 0.82em;
  }
  .tag {
    display: inline-block; background: #2E7D32; color: #fff;
    border-radius: 20px; padding: 2px 11px; font-size: 0.68em;
    font-weight: 700; margin: 2px 2px; letter-spacing: 0.02em;
  }
  .tag-blue  { background: #1565C0; }
  .tag-org   { background: #E65100; }
  .tag-gray  { background: #546E7A; }

  .arch-box {
    border: 2px solid #4CAF50; border-radius: 8px;
    padding: 8px 12px; margin: 4px 0; font-size: 0.78em;
    text-align: center; background: #fff;
  }
  .arch-box strong { color: #1B5E20; }
  .arch-box small  { color: #666; display: block; font-size: 0.85em; }
  .arch-arrow { text-align: center; color: #81C784; font-size: 1.3em; margin: 1px 0; line-height: 1; }

  section.cover {
    background: linear-gradient(145deg, #1B5E20 0%, #2E7D32 55%, #43A047 100%);
    color: #fff;
    display: flex; flex-direction: column; justify-content: center;
    padding: 56px 68px;
  }
  section.cover h1 { color: #fff; border-bottom: 3px solid rgba(255,255,255,0.35); font-size: 2.8em; margin-bottom: 12px; }
  section.cover .sub  { color: #C8E6C9; font-size: 1.0em; margin-bottom: 28px; }
  section.cover .meta { color: rgba(255,255,255,0.82); font-size: 0.80em; line-height: 2.1; }
  section.cover::after { color: rgba(255,255,255,0.3); }

  section.divider {
    background: #F1F8E9;
    display: flex; flex-direction: column; justify-content: center; align-items: center; text-align: center;
  }
  section.divider h1 { border: none; font-size: 2.6em; }
  section.divider p  { color: #555; font-size: 0.88em; margin-top: 6px; }

  img { border-radius: 10px; box-shadow: 0 4px 16px rgba(0,0,0,0.18); }
---

<!-- _class: cover -->

# 🌿 EcoQuest

<div class="sub">Plataforma de concienciación ambiental gamificada</div>

<div class="meta">
  👥 <strong>Equipo Prompt</strong> &nbsp;·&nbsp; IES Doctor Balmis &nbsp;·&nbsp; DAM 2025–2026<br/>
  📱 App Android &nbsp;·&nbsp; ☁️ API REST &nbsp;·&nbsp; 🖥️ Panel WPF
</div>

---

# 💡 Introducción

<div class="cols2">
<div>

## ¿Por qué EcoQuest?

- 🌍 La gente quiere actuar, pero no sabe cómo
- 🏘️ Falta de canales para organizarse localmente
- 🎮 Las apps verdes existentes no enganchan

## Nuestra propuesta

- Comunidades vecinales conectadas
- Eventos y retos ecológicos reales
- Sistema de puntos que motiva

</div>
<div>

<div class="card">
  <strong>🎯 Objetivo</strong><br/>
  Fomentar hábitos sostenibles mediante comunidades locales, eventos reales y recompensas.
</div>
<div class="card">
  <strong>👥 Usuarios</strong><br/>
  <span class="tag">Ciudadano</span> App Android<br/>
  <span class="tag tag-gray">Administrador</span> Panel WPF
</div>
<div class="card">
  <strong>🔗 Integración total</strong><br/>
  Móvil y escritorio comparten datos en tiempo real a través de la misma API REST.
</div>

</div>
</div>

---

# 🏛️ Arquitectura del sistema

<div class="cols2">
<div>

<div class="arch-box"><strong>📱 App Android</strong><small>Kotlin · Jetpack Compose · Hilt · Room · Retrofit</small></div>
<div class="arch-arrow">⬆️⬇️&nbsp; REST / JWT</div>
<div class="arch-box" style="border-color:#1565C0"><strong>☁️ API REST</strong><small>Spring Boot 3.4 · Java 21 · Puerto 9000</small></div>
<div class="arch-arrow">⬆️⬇️&nbsp; JPA / Hibernate</div>
<div class="arch-box" style="border-color:#6A1B9A"><strong>🗄️ Base de datos</strong><small>PostgreSQL (prod) · H2 (dev)</small></div>
<div class="arch-arrow">⬆️⬇️&nbsp; REST / JWT</div>
<div class="arch-box" style="border-color:#E65100"><strong>🖥️ Panel Admin WPF</strong><small>C# · .NET · MVVM</small></div>

</div>
<div>

## Android — MVVM por pantalla

```
Compose UI  ←  estado (UiState)
     ↓  eventos (sealed interface)
ViewModel   ←  Hilt @Inject
     ↓
Repository
  ↓          ↓
Room DB    Retrofit
(offline)  (API REST)
```

- Cada feature: `Screen` + `ViewModel` + `UiState` + `Event`
- Estado reactivo: `Flow` + `mutableStateOf`
- Navegación type-safe con `@Serializable`

</div>
</div>

---

<!-- _class: divider -->

# 📱 App Android

### Funcionalidades y pantallas

---

# 🔐 Autenticación

<div class="cols2">
<div class="center">

![height:400px](slides_img/login.png)
<div class="caption">Inicio de sesión con correo y contraseña</div>

</div>
<div class="center">

![height:400px](slides_img/registro.png)
<div class="caption">Registro con validación de campos</div>

</div>
</div>

---

# 🏠 Pantalla principal y navegación

<div class="cols2">
<div class="center">

![height:400px](slides_img/plantilla.png)
<div class="caption">Home con navegación inferior: Home · Comunidad · Tienda</div>

</div>
<div>

## Estructura de navegación

- Barra inferior fija con 3 destinos principales
- Icono de perfil en la esquina superior izquierda
- Icono de ajustes en la esquina superior derecha
- Fondo generativo con paisaje animado en Compose Canvas

<div class="card" style="margin-top: 16px">
  🎨 <strong>Canvas personalizado</strong><br/>
  El paisaje de colinas se dibuja con <code>DrawScope</code> y trazados cúbicos (<code>cubicTo</code>) — sin imágenes, solo código.
</div>

</div>
</div>

---

# 🤝 Comunidades

<div class="cols2">
<div class="center">

![height:390px](slides_img/comunidades.png)
<div class="caption">Lista de comunidades disponibles</div>

</div>
<div class="center">

![height:390px](slides_img/comunidad.png)
<div class="caption">Detalle de comunidad con lista de eventos</div>

</div>
</div>

---

# 🤝 Crear y editar comunidad

<div class="cols2">
<div class="center">

![height:400px](slides_img/crear_comunidad.png)
<div class="caption">Diálogo: crear nueva comunidad</div>

</div>
<div class="center">

![height:400px](slides_img/editar_comunidad.png)
<div class="caption">Diálogo: editar comunidad existente</div>

</div>
</div>

---

# 📅 Eventos

<div class="cols2">
<div class="center">

![height:390px](slides_img/eventos_lista.png)
<div class="caption">Feed de eventos con búsqueda en tiempo real</div>

</div>
<div class="center">

![height:390px](slides_img/crear_evento.png)
<div class="caption">Formulario de creación de evento</div>

</div>
</div>

---

# 📅 Editar eventos

<div class="cols2">
<div class="center">

![height:400px](slides_img/editar_evento.png)
<div class="caption">Editor de evento con datos precargados</div>

</div>
<div>

## Tipos de evento

<div class="card">📢 <strong>Evento Comunitario</strong><br/>Actividades organizadas por la comunidad</div>
<div class="card">📰 <strong>Noticia</strong><br/>Información relevante para los miembros</div>
<div class="card">🚨 <strong>Urgente</strong><br/>Acciones que requieren respuesta inmediata</div>

</div>
</div>

---

# 🏪 Tienda de Puntos

<div class="cols2">
<div class="center">

![height:400px](slides_img/tienda.png)
<div class="caption">Puntos disponibles y producto destacado</div>

</div>
<div class="center">

![height:400px](slides_img/tienda_complementos.png)
<div class="caption">Catálogo de complementos canjeables</div>

</div>
</div>

---

# 👤 Perfil de usuario

<div class="cols2">
<div class="center">

![height:430px](slides_img/perfil.png)
<div class="caption">Perfil con nivel, logros y progreso al siguiente nivel</div>

</div>
<div>

## Gamificación del perfil

- Sistema de niveles (ej. Nivel 5 - Basurita)
- Barra de progreso hacia el siguiente nivel
- Logros personales por acciones ecológicas
- Título desbloqueado al subir de nivel

<div class="card" style="margin-top:16px">
  🏆 <strong>Ejemplo de logro</strong><br/>
  "Has salvado 12 árboles con tus acciones. La naturaleza te aplaude."
</div>

</div>
</div>

---

<!-- _class: divider -->

# 🖥️ Panel de Administración

### WPF · C# · .NET · MVVM

---

# 🖥️ Gestión de usuarios

<div class="cols2">
<div class="center">

![height:370px](slides_img/escritorio_usuarios.png)
<div class="caption">Lista de todos los usuarios registrados</div>

</div>
<div class="center">

![height:370px](slides_img/escritorio_bloquear.png)
<div class="caption">Diálogo de bloqueo con causa y duración</div>

</div>
</div>

---

# 🖥️ Gestión de comunidades

<div class="cols2">
<div class="center">

![height:360px](slides_img/escritorio_comunidades.png)
<div class="caption">Lista de comunidades activas</div>

</div>
<div class="center">

![height:360px](slides_img/escritorio_revision_comunidades.png)
<div class="caption">Comunidades pendientes de aprobación</div>

</div>
</div>

<div class="center" style="margin-top:10px">

![height:240px](slides_img/escritorio_aceptar.png)
<div class="caption">Vista detalle para aceptar o denegar una comunidad</div>

</div>

---

# 🖥️ Gestión de eventos

<div class="cols2">
<div class="center">

![height:360px](slides_img/escritorio_eventos.png)
<div class="caption">Lista de todos los eventos</div>

</div>
<div class="center">

![height:360px](slides_img/escritorio_eventos_revision.png)
<div class="caption">Eventos pendientes de revisión</div>

</div>
</div>

<div class="center" style="margin-top:10px">

![height:240px](slides_img/escritorio_evento_revision.png)
<div class="caption">Detalle del evento para aprobar o rechazar</div>

</div>

---

# 🖥️ Gestión de accesorios (Tienda)

<div class="cols3">
<div class="center">

![height:300px](slides_img/escritorio_accesorios.png)
<div class="caption">Catálogo de accesorios</div>

</div>
<div class="center">

![height:300px](slides_img/escritorio_add_accesorio.png)
<div class="caption">Añadir accesorio nuevo</div>

</div>
<div class="center">

![height:300px](slides_img/escritorio_edit_accesorio.png)
<div class="caption">Editar accesorio existente</div>

</div>
</div>

---

# 🔧 Características técnicas destacables

<div class="cols2">
<div>

## Estado reactivo — Flow + Compose

```kotlin
// ViewModel: un único estado observable
var state by mutableStateOf(EventosUiState())
    private set

init {
    viewModelScope.launch {
        // Flow de Room: la UI se actualiza sola
        // cuando cambia la base de datos
        repo.getAll().collect { lista ->
            state = state.copy(eventos = lista)
        }
    }
}
```

## Inyección de dependencias — Hilt

```kotlin
@HiltViewModel
class EventosViewModel @Inject constructor(
    private val repo: EventoRepository
) : ViewModel()
```

</div>
<div>

## Autenticación JWT — Retrofit interceptor

```kotlin
class AuthInterceptor(private val token: String)
    : Interceptor {
    override fun intercept(chain: Chain) =
        chain.proceed(
            chain.request().newBuilder()
                .header("Authorization", "Bearer $token")
                .build()
        )
}
```

## Room — datos offline + seed idempotente

```kotlin
// IGNORE: no sobreescribe si ya existe
@Insert(onConflict = OnConflictStrategy.IGNORE)
suspend fun insertAllIfAbsent(
    eventos: List<EventoEntity>
)
```

</div>
</div>

---

# 🏁 Conclusión

<div class="cols2">
<div>

## Lo que hemos construido

- 📱 App Android con 10+ pantallas funcionales
- ☁️ API REST con autenticación JWT
- 🖥️ Panel WPF con gestión completa
- 🔗 Las 3 plataformas conectadas en tiempo real

## Posibles ampliaciones

- 📍 Geolocalización de eventos en mapa
- 🤖 Retos personalizados con IA
- 🔔 Notificaciones push
- 🌐 Versión web responsive

</div>
<div>

## El equipo — Equipo Prompt

<div class="card">
  ✅ <strong>Puntos fuertes</strong><br/>
  Reparto claro por plataforma. Buen uso de Git para integrar el trabajo de todo el equipo.
</div>
<div class="card">
  ⚡ <strong>Mayor reto</strong><br/>
  Coordinar 3 plataformas distintas sobre una sola API requirió definir bien los contratos desde el principio.
</div>
<div class="card">
  📚 <strong>Mayor aprendizaje</strong><br/>
  Jetpack Compose y MVVM en un proyecto real de tamaño considerable. También la integración completa backend ↔ móvil ↔ escritorio.
</div>

</div>
</div>

---

<!-- _class: cover -->

# 🌿 ¡Gracias!

<div class="sub">Esta ha sido nuestra propuesta — EcoQuest</div>

<div class="meta">
  👥 <strong>Equipo Prompt</strong> &nbsp;·&nbsp; IES Doctor Balmis · DAM 2025–2026<br/><br/>
  🔗 github.com/Prompt-pi2damiesbalmis/PROYECTOI2
</div>
