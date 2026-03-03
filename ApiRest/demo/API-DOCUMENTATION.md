# 📚 Documentación API REST - Plataforma Gamificación

## 🎯 Descripción General

Esta es una API REST completa para una plataforma de gamificación construida con **Spring Boot**, **JPA/Hibernate** y base de datos **H2**.

## 🚀 Inicio Rápido

### Requisitos
- Java 21+
- Maven 3.6+

### Ejecutar la Aplicación
```bash
cd demo
mvn clean install
mvn spring-boot:run
```

La API estará disponible en: `http://localhost:8080`

### Acceso a Base de Datos
- **H2 Console**: http://localhost:8080/h2-console
- **Usuario**: sa
- **Contraseña**: (dejar en blanco)

---

## 📡 Endpoints de la API

### 1. USUARIOS `/api/usuarios`

#### Obtener todos los usuarios
```
GET /api/usuarios
```
**Respuesta (200 OK)**:
```json
[
  {
    "usuarioId": 1,
    "usuario": "juan123",
    "nombre": "Juan",
    "apellidos": "Pérez López",
    "correo": "juan@email.com",
    "admin": false,
    "puntos": 150,
    "puntosExperiencia": 500
  }
]
```

#### Obtener usuario por ID
```
GET /api/usuarios/{id}
```

#### Crear nuevo usuario
```
POST /api/usuarios
Content-Type: application/json

{
  "usuario": "nuevo_user",
  "contraseña": "pass123",
  "nombre": "Carlos",
  "apellidos": "García",
  "correo": "carlos@email.com",
  "admin": false,
  "puntos": 0,
  "puntosExperiencia": 0
}
```
**Respuesta (201 CREATED)**: Devuelve el usuario creado con su ID.

#### Actualizar usuario
```
PUT /api/usuarios/{id}
Content-Type: application/json

{
  "nombre": "Carlos Actualizado",
  "apellidos": "García López",
  "puntos": 200
}
```

#### Eliminar usuario
```
DELETE /api/usuarios/{id}
```
**Respuesta (204 NO CONTENT)**

---

### 2. COMUNIDADES `/api/comunidades`

#### Obtener todas las comunidades
```
GET /api/comunidades
```

#### Obtener comunidad por ID
```
GET /api/comunidades/{id}
```

#### Crear comunidad
```
POST /api/comunidades
Content-Type: application/json

{
  "nombre": "Comunidad de Programadores",
  "descripcion": "Para amantes del código",
  "imagen": "url_imagen"
}
```

#### Actualizar comunidad
```
PUT /api/comunidades/{id}
Content-Type: application/json

{
  "nombre": "Comunidad Actualizada"
}
```

#### Eliminar comunidad
```
DELETE /api/comunidades/{id}
```

---

### 3. EVENTOS `/api/eventos`

#### Obtener todos los eventos
```
GET /api/eventos
```

#### Obtener evento por ID
```
GET /api/eventos/{id}
```

#### Crear evento
```
POST /api/eventos
Content-Type: application/json

{
  "nombre": "Hackathon 2024",
  "ubicacion": "Centro de Innovación",
  "descripcion": "Competencia de 48 horas",
  "imagen": "url_imagen",
  "fecha": "2024-06-15T14:00:00"
}
```

#### Actualizar evento
```
PUT /api/eventos/{id}
```

#### Eliminar evento
```
DELETE /api/eventos/{id}
```

---

### 4. PRODUCTOS `/api/productos`

#### Obtener todos los productos
```
GET /api/productos
```

#### Obtener producto por ID
```
GET /api/productos/{id}
```

#### Crear producto
```
POST /api/productos
Content-Type: application/json

{
  "nombre": "Badge Programador",
  "descripcion": "Badge especial para programadores",
  "puntos": 100
}
```

#### Actualizar producto
```
PUT /api/productos/{id}
```

#### Eliminar producto
```
DELETE /api/productos/{id}
```

---

### 5. RETOS `/api/retos`

#### Obtener todos los retos
```
GET /api/retos
```

#### Obtener reto por ID
```
GET /api/retos/{id}
```

#### Crear reto
```
POST /api/retos
Content-Type: application/json

{
  "nombre": "Reto de Javascript",
  "descripcion": "Resuelve 10 problemas de JS",
  "puntos": 250
}
```

#### Actualizar reto
```
PUT /api/retos/{id}
```

#### Eliminar reto
```
DELETE /api/retos/{id}
```

---

### 6. NIVELES `/api/niveles`

#### Obtener todos los niveles
```
GET /api/niveles
```

#### Obtener nivel por ID
```
GET /api/niveles/{id}
```

#### Crear nivel
```
POST /api/niveles
Content-Type: application/json

{
  "nombre": "Principiante",
  "descripcion": "Nivel inicial",
  "puntos": 0,
  "icono": "star"
}
```

#### Actualizar nivel
```
PUT /api/niveles/{id}
```

#### Eliminar nivel
```
DELETE /api/niveles/{id}
```

---

### 7. ROLES `/api/roles`

#### Obtener todos los roles
```
GET /api/roles
```

#### Obtener rol por ID
```
GET /api/roles/{id}
```

#### Crear rol
```
POST /api/roles
Content-Type: application/json

{
  "nombreRol": "Administrador"
}
```

#### Actualizar rol
```
PUT /api/roles/{id}
Content-Type: application/json

{
  "nombreRol": "Moderador"
}
```

#### Eliminar rol
```
DELETE /api/roles/{id}
```

---

### 8. NOTICIAS `/api/noticias`

#### Obtener todas las noticias
```
GET /api/noticias
```

#### Obtener noticia por ID
```
GET /api/noticias/{id}
```

#### Crear noticia
```
POST /api/noticias
Content-Type: application/json

{
  "nombre": "Nuevo torneo",
  "autor": "Admin",
  "descripcion": "Se anuncia el nuevo torneo de programación",
  "imagen": "url_imagen"
}
```

#### Actualizar noticia
```
PUT /api/noticias/{id}
```

#### Eliminar noticia
```
DELETE /api/noticias/{id}
```

---

## 🔍 Endpoint de Información

### Obtener información de la API
```
GET /api
```

**Respuesta**:
```json
{
  "nombre": "API REST - Plataforma Gamificación",
  "version": "1.0.0",
  "estado": "Activa",
  "timestamp": "2024-02-24T10:30:00",
  "endpoints": [...]
}
```

### Health Check
```
GET /api/health
```

---

## 📊 Estructura Base de Datos

### Tablas principales
- **usuarios** - Información de usuarios
- **comunidades** - Información de comunidades
- **eventos** - Información de eventos
- **productos** - Información de productos
- **retos** - Información de retos
- **niveles** - Información de niveles
- **roles** - Información de roles
- **noticias** - Información de noticias

### Tablas de relación
- **usuario_comunidad** - Relación M2M entre usuarios y comunidades
- **usuario_evento** - Relación M2M entre usuarios y eventos
- **usuario_producto** - Relación M2M entre usuarios y productos
- **usuario_reto** - Relación M2M entre usuarios y retos

---

## 🛠️ Códigos de Respuesta HTTP

| Código | Descripción |
|--------|-------------|
| 200 | OK - Solicitud exitosa |
| 201 | CREATED - Recurso creado |
| 204 | NO CONTENT - Eliminación exitosa |
| 400 | BAD REQUEST - Solicitud inválida |
| 404 | NOT FOUND - Recurso no encontrado |
| 500 | INTERNAL SERVER ERROR - Error del servidor |

---

## 📝 Configuración application.properties

```properties
spring.application.name=demo
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🔐 CORS

La API está configurada para aceptar requests desde cualquier origen con los siguientes métodos:
- GET
- POST
- PUT
- DELETE
- OPTIONS

---

## 🧪 Ejemplo con cURL

### Crear un usuario
```bash
curl -X POST http://localhost:8080/api/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "usuario": "test_user",
    "contraseña": "pass123",
    "nombre": "Test",
    "apellidos": "Usuario",
    "correo": "test@email.com",
    "admin": false,
    "puntos": 0,
    "puntosExperiencia": 0
  }'
```

### Obtener todos los usuarios
```bash
curl http://localhost:8080/api/usuarios
```

### Actualizar usuario
```bash
curl -X PUT http://localhost:8080/api/usuarios/1 \
  -H "Content-Type: application/json" \
  -d '{"nombre": "Juan Actualizado"}'
```

### Eliminar usuario
```bash
curl -X DELETE http://localhost:8080/api/usuarios/1
```

---

## 📚 Tecnologías Utilizadas

- **Spring Boot 4.0.3**
- **Spring Data JPA**
- **Hibernate**
- **H2 Database**
- **MySQL Driver** (opcional para cambiar a MySQL)
- **Java 21**
- **Maven**

---

## 🎓 Autor
Proyecto de API REST para plataforma de gamificación

## 📄 Licencia
MIT License

---

**¡La API está lista para usar!** 🚀
