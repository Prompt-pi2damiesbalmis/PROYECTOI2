# 🎮 API REST - Plataforma de Gamificación

## Descripción

API REST completa y funcional para una plataforma de gamificación. Construida con **Spring Boot 4**, **JPA/Hibernate** y base de datos **H2** (en memoria).

## 📋 Características

✅ **CRUD Completo** - Operaciones Create, Read, Update, Delete para todas las entidades
✅ **8 Entidades principales** - Usuarios, Comunidades, Eventos, Productos, Retos, Niveles, Roles, Noticias
✅ **Relaciones complejas** - ManyToMany, ManyToOne, OneToMany
✅ **Base de datos H2** - En memoria, lista para cambiar a MySQL/PostgreSQL
✅ **CORS habilitado** - Compatible con aplicaciones frontend
✅ **Manejo global de excepciones** - Controlador centralizado de errores
✅ **Documentación completa** - Endpoints y ejemplos incluidos
✅ **Datos de prueba** - Scripts SQL para inicializar la BD

## 🚀 Inicio Rápido

### 1. Clonar/Descargar el proyecto
```bash
cd demo
```

### 2. Compilar el proyecto
```bash
mvn clean install
```

### 3. Ejecutar la aplicación
```bash
mvn spring-boot:run
```

### 4. Acceder a la API
- **API Base URL**: http://localhost:8080/api
- **H2 Console**: http://localhost:8080/h2-console
- **Health Check**: http://localhost:8080/api/health

## 📚 Estructura del Proyecto

```
demo/
├── src/
│   ├── main/
│   │   ├── java/com/proyecto/apirest/
│   │   │   ├── controllers/        # Controladores REST (8 entidades)
│   │   │   ├── repositories/       # Interfaces JpaRepository
│   │   │   ├── config/             # Configuración (CORS, Exception Handler)
│   │   │   ├── dto/                # Data Transfer Objects
│   │   │   ├── demo/               # Clase principal (DemoApplication.java)
│   │   │   └── models/             # Entidades JPA (modelos de BD)
│   │   └── resources/
│   │       ├── application.properties    # Configuración de la aplicación
│   │       └── data.sql                  # Datos iniciales para H2
│   └── test/
├── pom.xml                         # Dependencias Maven
├── API-DOCUMENTATION.md            # Documentación completa de endpoints
└── README.md                        # Este archivo
```

## 🌐 Endpoints Disponibles

### Recursos Principales
- `GET/POST /api/usuarios` - Gestión de usuarios
- `GET/POST /api/comunidades` - Gestión de comunidades
- `GET/POST /api/eventos` - Gestión de eventos
- `GET/POST /api/productos` - Gestión de productos
- `GET/POST /api/retos` - Gestión de retos
- `GET/POST /api/niveles` - Gestión de niveles
- `GET/POST /api/roles` - Gestión de roles
- `GET/POST /api/noticias` - Gestión de noticias

### Operaciones CRUD
- **GET** `/api/{recurso}` - Obtener todos
- **GET** `/api/{recurso}/{id}` - Obtener por ID
- **POST** `/api/{recurso}` - Crear nuevo
- **PUT** `/api/{recurso}/{id}` - Actualizar
- **DELETE** `/api/{recurso}/{id}` - Eliminar

### Información
- `GET /api` - Información de la API
- `GET /api/health` - Estado de la API

## 💾 Base de Datos H2

### Acceso a H2 Console
1. Abre: http://localhost:8080/h2-console
2. Usuario: `sa`
3. Contraseña: (dejar en blanco)
4. JDBC URL: `jdbc:h2:mem:testdb`

### Características
- **En memoria** - Se reinicia cada vez que se ejecuta la aplicación
- **Auto-DDL** - Las tablas se crean automáticamente desde las entidades
- **Datos iniciales** - Se cargan desde `data.sql`

## 📝 Ejemplo de Uso con cURL

### Crear usuario
```bash
curl -X POST http://localhost:8080/api/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "usuario": "juan_dev",
    "contraseña": "segura123",
    "nombre": "Juan",
    "apellidos": "Desarrollador",
    "correo": "juan@example.com",
    "admin": false,
    "puntos": 100,
    "puntosExperiencia": 500
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
  -d '{"nombre": "Juan Roberto"}'
```

### Obtener evento específico
```bash
curl http://localhost:8080/api/eventos/1
```

### Eliminar noticia
```bash
curl -X DELETE http://localhost:8080/api/noticias/1
```

## 🔧 Configuración

### application.properties
```properties
spring.application.name=demo
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

### Cambiar a MySQL (opcional)
1. Agregar dependencia MySQL en pom.xml
2. Actualizar application.properties:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gamification
spring.datasource.username=root
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

## 📦 Dependencias Principales

- **Spring Boot Starter Web** - Para construcción de APIs REST
- **Spring Data JPA** - Para acceso a datos con Hibernate
- **H2 Database** - Base de datos en memoria
- **Spring Boot DevTools** - Para desarrollo rápido
- **Lombok** (opcional) - Para reducir código boilerplate

## 🛠️ Entidades y Relaciones

### Usuario
- Campos: usuarioId, usuario, contraseña, nombre, apellidos, correo, admin, puntos, etc.
- Relaciones: ManyToMany con Comunidad, Evento, Reto, Producto

### Comunidad
- Campos: comunidadId, nombre, descripcion, imagen
- Relaciones: ManyToMany con Usuario, OneToMany con Evento

### Evento
- Campos: eventoId, nombre, ubicacion, descripcion, fecha
- Relaciones: ManyToMany con Usuario, ManyToOne con Comunidad

### Producto
- Campos: productoId, nombre, descripcion, puntos
- Relaciones: ManyToMany con Usuario

### Reto
- Campos: retoId, nombre, descripcion, puntos
- Relaciones: ManyToMany con Usuario

### Nivel
- Campos: nivelId, nombre, descripcion, puntos, icono
- Relaciones: OneToMany con Usuario

### Rol
- Campos: id, nombreRol
- Relaciones: OneToMany con Comunidad

### Noticia
- Campos: noticiaId, nombre, autor, descripcion, imagen

## 🔒 CORS Configuration

La API está configurada para aceptar requests CORS en:
- **Orígenes**: Todos (`*`)
- **Métodos**: GET, POST, PUT, DELETE, OPTIONS
- **Headers**: Todos permitidos
- **Max Age**: 3600 segundos

## 📊 Códigos de Respuesta

| Código | Significado |
|--------|------------|
| 200 | OK - Solicitud exitosa |
| 201 | CREATED - Recurso creado |
| 204 | NO CONTENT - Eliminación exitosa |
| 400 | BAD REQUEST - Solicitud inválida |
| 404 | NOT FOUND - Recurso no encontrado |
| 500 | INTERNAL SERVER ERROR - Error del servidor |

## 🧪 Testing

Para validar que la API funciona:

1. **Verificar que está activa**:
   ```bash
   curl http://localhost:8080/api
   ```

2. **Verificar health**:
   ```bash
   curl http://localhost:8080/api/health
   ```

3. **Crear y listar usuarios**:
   ```bash
   # Crear
   curl -X POST http://localhost:8080/api/usuarios ...
   
   # Listar
   curl http://localhost:8080/api/usuarios
   ```

## 📖 Documentación Adicional

Ve el archivo **API-DOCUMENTATION.md** para:
- Lista completa de todos los endpoints
- Ejemplos detallados de cada operación
- Estructura de respuestas JSON
- Casos de uso comunes

## 🐛 Troubleshooting

### Puerto 8080 en uso
```bash
# Cambiar puerto en application.properties
server.port=8081
```

### Error de conexión a BD
- Verificar que H2 esté en classpath (pom.xml)
- Revisar application.properties

### Cambios no se guardan
- Validar que el datasource está en memoria correctamente
- Revisar logs de Hibernate

## 🎓 Próximos Pasos

- [ ] Agregar autenticación (JWT)
- [ ] Implementar Rate Limiting
- [ ] Agregar Swagger/OpenAPI
- [ ] Tests unitarios
- [ ] Tests de integración
- [ ] Validaciones con Bean Validator
- [ ] Paginación en listados

## 👨‍💻 Autor

Proyecto de API REST para plataforma de gamificación

## 📄 Licencia

MIT License - Puedes usar este código libremente

---

**¡La plataforma está lista para usar!** 🚀

Para más detalles, consulta **API-DOCUMENTATION.md**
