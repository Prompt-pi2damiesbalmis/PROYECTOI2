# 🚀 INICIO RÁPIDO - Tutoriales y Comandos

## 📥 Opción 1: Ejecutar con Scripts (RECOMENDADO)

### En Windows:
```bash
run.bat
```

### En Linux/Mac:
```bash
bash run.sh
```

---

## 📥 Opción 2: Comandos Maven Directos

### 1. Limpiar proyecto previo
```bash
mvn clean
```

### 2. Compilar e instalar dependencias
```bash
mvn install
```

### 3. Ejecutar Spring Boot
```bash
mvn spring-boot:run
```

### 4. Compilar y ejecutar en un comando
```bash
mvn clean install spring-boot:run
```

---

## 🧪 Opciones 3: Verificar que funciona

### Abrir navegador:
```
http://localhost:8080/api
```

### Usar cURL - Info API:
```bash
curl http://localhost:8080/api
```

### Usar cURL - Health Check:
```bash
curl http://localhost:8080/api/health
```

### Ver base de datos H2:
```
http://localhost:8080/h2-console
Usuario: sa
Contraseña: (vacío)
JDBC URL: jdbc:h2:mem:testdb
```

---

## 📝 EJEMPLOS DE REQUESTS CURL

### 1️⃣ Crear Usuario
```bash
curl -X POST http://localhost:8080/api/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "usuario": "juan123",
    "contraseña": "pass123",
    "nombre": "Juan",
    "apellidos": "Pérez",
    "correo": "juan@example.com",
    "admin": false,
    "puntos": 0,
    "puntosExperiencia": 0
  }'
```

### 2️⃣ Obtener Todos Usuarios
```bash
curl http://localhost:8080/api/usuarios
```

### 3️⃣ Obtener Usuario por ID
```bash
curl http://localhost:8080/api/usuarios/1
```

### 4️⃣ Actualizar Usuario
```bash
curl -X PUT http://localhost:8080/api/usuarios/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Juan Actualizado",
    "puntos": 150
  }'
```

### 5️⃣ Eliminar Usuario
```bash
curl -X DELETE http://localhost:8080/api/usuarios/1
```

---

## 📚 EJEMPLOS CON OTROS RECURSOS

### Comunidades
```bash
# Obtener todas
curl http://localhost:8080/api/comunidades

# Crear
curl -X POST http://localhost:8080/api/comunidades \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Python Developers",
    "descripcion": "Comunidad de desarrolladores Python"
  }'
```

### Eventos
```bash
# Obtener todos
curl http://localhost:8080/api/eventos

# Crear
curl -X POST http://localhost:8080/api/eventos \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Meetup Python",
    "ubicacion": "Centro Innovación",
    "descripcion": "Encuentro mensual",
    "fecha": "2024-03-15T18:00:00"
  }'
```

### Productos
```bash
# Obtener todos
curl http://localhost:8080/api/productos

# Crear
curl -X POST http://localhost:8080/api/productos \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Badge Certificado",
    "descripcion": "Badge de certificación",
    "puntos": 250
  }'
```

### Retos
```bash
# Obtener todos
curl http://localhost:8080/api/retos

# Crear
curl -X POST http://localhost:8080/api/retos \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Reto JavaScript",
    "descripcion": "Domina JavaScript",
    "puntos": 300
  }'
```

### Niveles
```bash
# Obtener todos
curl http://localhost:8080/api/niveles

# Crear
curl -X POST http://localhost:8080/api/niveles \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Experto",
    "descripcion": "Nivel máximo",
    "puntos": 5000,
    "icono": "⭐⭐⭐⭐"
  }'
```

### Roles
```bash
# Obtener todos
curl http://localhost:8080/api/roles

# Crear
curl -X POST http://localhost:8080/api/roles \
  -H "Content-Type: application/json" \
  -d '{"nombreRol": "Mentor"}'
```

### Noticias
```bash
# Obtener todas
curl http://localhost:8080/api/noticias

# Crear
curl -X POST http://localhost:8080/api/noticias \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Nuevo Update",
    "autor": "Admin",
    "descripcion": "Nueva versión disponible"
  }'
```

---

## 💻 USAR POSTMAN

1. Descargar [Postman](https://www.postman.com/downloads/)
2. Crear nueva colección
3. Agregar requests manuales o importar `API-EXAMPLES.json`

### Importar colección:
- Archivo → Import
- Seleccionar `API-EXAMPLES.json`
- ¡Listo! Tendrás todos los endpoints preconfigurados

---

## 🔍 VERIFICAR ESTADO

```bash
# ¿La aplicación está corriendo?
curl -i http://localhost:8080/api/health

# Ver versión Java
java -version

# Ver versión Maven
mvn -version
```

---

## 🐛 TROUBLESHOOTING

### Puerto 8080 en uso
```bash
# Linux/Mac - Encontrar proceso
lsof -i :8080

# Windows - Encontrar proceso
netstat -ano | findstr :8080

# Cambiar puerto en application.properties
server.port=8081
```

### Error: Maven no encontrado
```bash
# Instalar Maven (si no está)
# Windows: Descargar de apache.org/maven
# Mac: brew install maven
# Linux: apt-get install maven
```

### Error de compilación
```bash
# Limpiar caché Maven
mvn clean

# Descargar dependencias nuevamente
mvn dependency:resolve
```

### BD no conecta
```bash
# Verificar en H2 Console:
# URL: jdbc:h2:mem:testdb
# Usuario: sa
# Contraseña: (vacío)

# Revisar application.properties está correctamente configurado
```

---

## 🎯 CHECKLIST DE VERIFICACIÓN

- [ ] Java 21+ instalado (`java -version`)
- [ ] Maven instalado (`mvn -version`)
- [ ] Proyecto compilado sin errores (`mvn clean install`)
- [ ] Aplicación corriendo (`mvn spring-boot:run`)
- [ ] API responde (`curl http://localhost:8080/api`)
- [ ] H2 Console accesible (`http://localhost:8080/h2-console`)
- [ ] Puedes crear un usuario
- [ ] Puedes listar usuarios
- [ ] Puedes actualizar usuario
- [ ] Puedes eliminar usuario

---

## 📊 ESTRUCTURA DE LOG ESPERADO

Cuando ejecutes `mvn spring-boot:run`, verás algo así:

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_|\__, | / / / /
 =========|_|==============|___/=/_/_/_/
...
Tomcat started on port(s): 8080
Started DemoApplication in X seconds
=============================
API REST iniciada correctamente
Acceder a: http://localhost:8080
H2 Console: http://localhost:8080/h2-console
=============================
```

---

## 🔗 LINKS ÚTILES

- **API Base**: http://localhost:8080/api
- **Health Check**: http://localhost:8080/api/health
- **H2 Console**: http://localhost:8080/h2-console
- **Documentación**: Ver archivo `API-DOCUMENTATION.md`
- **Ejemplos**: Ver archivo `API-EXAMPLES.json`

---

## 📞 RESUMEN RÁPIDO

| Comando | Función |
|---------|---------|
| `mvn clean` | Limpia compilación anterior |
| `mvn install` | Descarga dependencias e instala |
| `mvn spring-boot:run` | Ejecuta la aplicación |
| `mvn clean install spring-boot:run` | Todo en uno |
| `./run.sh` | Script automatizado (Linux/Mac) |
| `run.bat` | Script automatizado (Windows) |

---

## ✅ ¡LISTO PARA EMPEZAR!

1. Ejecuta `mvn spring-boot:run` o los scripts
2. Abre http://localhost:8080/api en tu navegador
3. ¡Comienza a hacer requests! 🚀

---

**Para más detalles, consulta `API-DOCUMENTATION.md` y `PROYECTO-RESUMEN.md`**
