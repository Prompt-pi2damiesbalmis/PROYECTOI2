---
marp: true
theme: default
paginate: true
html: true
style: |
  :root {
    --color-primary: #2E7D32;
    --color-primary-dark: #1B5E20;
    --color-primary-light: #4CAF50;
    --color-accent: #81C784;
    --color-bg: #F1F8E9;
    --color-text: #1a1a1a;
  }

  section {
    font-family: "Segoe UI", Arial, sans-serif;
    background: #ffffff;
    color: var(--color-text);
    padding: 48px 56px;
  }

  section::after {
    color: #9E9E9E;
    font-size: 0.75em;
  }

  h1 {
    color: var(--color-primary-dark);
    font-size: 2.0em;
    border-bottom: 4px solid var(--color-primary);
    padding-bottom: 10px;
    margin-bottom: 24px;
  }

  h2 {
    color: var(--color-primary);
    font-size: 1.6em;
    margin-bottom: 20px;
  }

  h3 {
    color: var(--color-primary-light);
    font-size: 1.1em;
    margin-bottom: 8px;
  }

  ul {
    margin-left: 1.2em;
    line-height: 1.9;
  }

  li {
    font-size: 0.95em;
  }

  code {
    background: var(--color-bg);
    color: var(--color-primary-dark);
    border-radius: 4px;
    padding: 2px 6px;
    font-size: 0.85em;
  }

  .columns {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 32px;
    align-items: start;
  }

  .columns-3 {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    gap: 20px;
    align-items: start;
  }

  .card {
    background: var(--color-bg);
    border-left: 5px solid var(--color-primary);
    border-radius: 8px;
    padding: 16px 20px;
    margin-bottom: 12px;
  }

  .tag {
    display: inline-block;
    background: var(--color-primary);
    color: white;
    border-radius: 20px;
    padding: 4px 14px;
    font-size: 0.78em;
    font-weight: 600;
    margin: 3px;
  }

  /* Slide de portada */
  section.cover {
    background: linear-gradient(150deg, #1B5E20 0%, #2E7D32 50%, #388E3C 100%);
    color: white;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: flex-start;
    padding: 60px 72px;
  }
  section.cover h1 {
    color: white;
    border-bottom: 3px solid rgba(255,255,255,0.4);
    font-size: 2.8em;
    margin-bottom: 16px;
  }
  section.cover h2 {
    color: #C8E6C9;
    font-size: 1.15em;
    margin-bottom: 32px;
    font-weight: 400;
  }
  section.cover p {
    color: rgba(255,255,255,0.85);
    font-size: 0.88em;
    line-height: 2.0;
  }
  section.cover::after { color: rgba(255,255,255,0.4); }

  /* Slide de sección */
  section.divider {
    background: var(--color-bg);
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
  }
  section.divider h1 {
    font-size: 2.6em;
    border: none;
  }
  section.divider p {
    color: #555;
    font-size: 1em;
    margin-top: 8px;
  }

  img {
    border-radius: 10px;
    box-shadow: 0 4px 16px rgba(0,0,0,0.15);
  }
---

<!-- _class: cover -->

# 🌿 EcoQuest

## Plataforma de concienciación ambiental gamificada

<p>
  👥 <strong>Equipo Prompt</strong> &nbsp;|&nbsp; IES Doctor Balmis &nbsp;|&nbsp; DAM 2025–2026<br/>
  📱 Android &nbsp;·&nbsp; ☁️ Spring Boot API &nbsp;·&nbsp; 🖥️ Panel WPF<br/>
  📅 Mayo 2026
</p>

---

# 🎯 ¿Qué es EcoQuest?

<div class="columns">
<div>

### El problema
- 🌍 La gente quiere actuar pero no sabe cómo
- 📣 Falta de comunidades locales activas
- 🎮 Las apps verdes son aburridas

### Nuestra solución
- 🏆 Gamificación de acciones ecológicas
- 🤝 Comunidades vecinales conectadas
- 📰 Eventos e información en tiempo real

</div>
<div>

<div class="card">
  <h3>🎯 Objetivo</h3>
  Fomentar hábitos sostenibles mediante recompensas, comunidades y retos ecológicos accesibles para todos.
</div>

<div class="card">
  <h3>👤 Usuario objetivo</h3>
  Ciudadanos 16–45 años comprometidos con el medio ambiente y su entorno local.
</div>

</div>
</div>

---

# 🛠️ Stack tecnológico

<div class="columns-3">
<div>

### 📱 Android
<span class="tag">Kotlin</span>
<span class="tag">Jetpack Compose</span>
<span class="tag">Hilt</span>
<span class="tag">Room</span>
<span class="tag">Retrofit</span>
<span class="tag">Coil</span>

</div>
<div>

### ☁️ Backend
<span class="tag">Spring Boot 3.4</span>
<span class="tag">Java 21</span>
<span class="tag">JWT</span>
<span class="tag">PostgreSQL</span>
<span class="tag">H2 (dev)</span>
<span class="tag">REST API</span>

</div>
<div>

### 🖥️ Admin Panel
<span class="tag">WPF</span>
<span class="tag">C#</span>
<span class="tag">.NET</span>
<span class="tag">MVVM</span>

### 🔧 Herramientas
<span class="tag">GitHub</span>
<span class="tag">Android Studio</span>

</div>
</div>

---

# 🏛️ Arquitectura

<div class="columns">
<div>

### Patrón MVVM

```
UI (Compose)
    ↕  eventos / estado
ViewModel (Hilt)
    ↕  repositorios
Repository
    ↕ ↕
  Room  Retrofit
(local) (remoto)
```

- ✅ Separación de responsabilidades
- ✅ Estado reactivo con `Flow`
- ✅ Inyección de dependencias (Hilt)
- ✅ Navegación type-safe (`@Serializable`)

</div>
<div>

### Capas del sistema

<div class="card">
  📱 <strong>App Android</strong><br/>MVVM · Compose · Room · Retrofit
</div>
<div class="card">
  ☁️ <strong>API REST</strong> (puerto 9000)<br/>Spring Boot · JWT · PostgreSQL
</div>
<div class="card">
  🖥️ <strong>Panel Administrador</strong><br/>WPF · C# · MVVM
</div>

</div>
</div>

---

# ✨ Funcionalidades principales

<div class="columns">
<div>

### 🔐 Autenticación
- Registro e inicio de sesión
- JWT seguro con refresh
- Perfil de usuario editable

### 🤝 Comunidades
- Explorar comunidades locales
- Unirse y participar
- Mural compartido por comunidad

</div>
<div>

### 📅 Eventos
- Feed de eventos comunitarios
- Filtrado por nombre en tiempo real
- Tipos: Comunitario · Noticia · Urgente

### 🏪 Tienda de Puntos
- Catálogo de recompensas
- Canjear puntos ganados
- Historial de actividad ecológica

</div>
</div>

---

<!-- _class: divider -->

# 📱 Demo
### Pantallas de la aplicación

---

# 🔐 Acceso y Perfil

<div class="columns">
<div style="text-align:center">

![height:380px](slides_img/login.png)
**Inicio de sesión**

</div>
<div style="text-align:center">

![height:380px](slides_img/perfil.png)
**Perfil de usuario**

</div>
</div>

---

# 🤝 Comunidades

<div class="columns">
<div style="text-align:center">

![height:380px](slides_img/comunidades.png)
**Explorar comunidades**

</div>
<div style="text-align:center">

![height:380px](slides_img/comunidad.png)
**Vista de comunidad**

</div>
</div>

---

# 📅 Eventos y Crear Evento

<div class="columns">
<div style="text-align:center">

![height:380px](slides_img/eventos.png)
**Feed de eventos**

</div>
<div style="text-align:center">

![height:380px](slides_img/crear_evento.png)
**Crear nuevo evento**

</div>
</div>

---

# 🏪 Tienda de Puntos

<div class="columns">
<div style="text-align:center">

![height:420px](slides_img/tienda.png)
**Canjear recompensas**

</div>
<div>

<div class="card">
  🏆 <strong>Sistema de puntos</strong><br/>
  Los usuarios acumulan puntos participando en eventos y retos ecológicos
</div>
<div class="card">
  🎁 <strong>Recompensas</strong><br/>
  Productos, descuentos y experiencias canjeables en la tienda
</div>
<div class="card">
  📊 <strong>Motivación</strong><br/>
  La gamificación incrementa la participación activa en la comunidad
</div>

</div>
</div>

---

# 🏁 Conclusiones

<div class="columns">
<div>

### ✅ Logros del proyecto
- Arquitectura MVVM sólida y escalable
- App Android funcional con 6 pantallas
- API REST con autenticación JWT
- Panel de administración WPF
- Integración Room + Retrofit

### 📚 Aprendizajes
- Jetpack Compose en producción
- Diseño orientado a capas
- Trabajo en equipo con Git

</div>
<div>

### 🚀 Próximos pasos

<div class="card">📍 Geolocalización de eventos</div>
<div class="card">🤖 IA para sugerir retos personalizados</div>
<div class="card">🌐 Versión web (React / Angular)</div>
<div class="card">📊 Dashboard de impacto ambiental</div>
<div class="card">🔔 Notificaciones push</div>

</div>
</div>

---

<!-- _class: cover -->

# 🌿 ¡Gracias!

## EcoQuest — Juntos por un planeta mejor

<p>
  👥 <strong>Equipo Prompt</strong><br/>
  🏫 IES Doctor Balmis · DAM 2025–2026<br/><br/>
  📧 Contacto: michelgg08@gmail.com<br/>
  🔗 GitHub: github.com/Prompt-pi2damiesbalmis/PROYECTOI2
</p>
