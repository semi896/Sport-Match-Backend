# Sport-Match-Backend

RESTful API del proyecto **Sport Match**, una plataforma web para descubrir, publicar y unirse a actividades deportivas. Este repositorio contiene el backend que consumen la Web Application y el Landing Page.

> Proyecto académico del curso de Aplicaciones Web (Ingeniería de Sistemas de Información).

## Tecnologías

| Componente       | Tecnología                                             |
| ---------------- | ------------------------------------------------------ |
| Lenguaje         | Java 17                                                |
| Framework        | Spring Boot 4.1.1 (Spring Web MVC, Spring Security)    |
| Persistencia     | Spring Data JPA + Hibernate                            |
| Base de datos    | PostgreSQL                                             |
| Documentación    | springdoc-openapi 2.8.5 (Swagger UI)                   |
| Utilidades       | Lombok, Thymeleaf                                      |
| Build            | Maven (wrapper incluido)                               |
| Despliegue       | Amazon EC2 (API) y Amazon RDS for PostgreSQL (BD)      |

## Funcionalidades (Sprint 2)

| Historia | Descripción                                    |
| -------- | ---------------------------------------------- |
| US01     | Crear perfil deportivo                         |
| US06     | Solicitar una plaza para participar            |
| US08     | Publicar una actividad                         |
| US09     | Consultar participantes para controlar el cupo |
| US10     | Actualizar una actividad                       |

## Estructura del proyecto

```
src/main/java/com/example/Sportmatch/
├── Controller/   # Endpoints REST (Actividad, Usuario, Participacion)
├── Service/      # Lógica de negocio (+ Impl/)
├── Repository/   # Acceso a datos (Spring Data JPA)
├── Entity/       # Entidades JPA
├── Dto/          # Objetos de transferencia (ActividadDto, UsuarioDto)
├── Security/     # SecurityConfig y JwtUtil
└── Exceptions/   # GlobalExceptionHandler
```

## Modelo de datos

| Entidad         | Descripción                                                          |
| --------------- | -------------------------------------------------------------------- |
| `Usuario`       | Cuenta base del sistema (nombre, email, contraseña, estado)          |
| `Jugador`       | Perfil deportivo del usuario                                         |
| `Organizador`   | Usuario que crea y administra actividades                            |
| `Actividad`     | Partido o evento deportivo (fecha y hora, cupos, estado)             |
| `Participacion` | Inscripción de un usuario en una actividad                           |
| `Deporte`       | Disciplinas deportivas disponibles                                   |
| `Ubicacion`     | Lugar físico de la actividad (dirección, ciudad, latitud, longitud)  |
| `Auditoria`     | Registro de acciones realizadas sobre los datos del sistema          |

## Requisitos previos

- JDK 17
- PostgreSQL en ejecución (local o Amazon RDS)
- Maven (opcional, el proyecto incluye `mvnw`)

## Instalación y ejecución local

```bash
# 1. Clonar el repositorio
git clone https://github.com/semi896/Sport-Match-Backend.git
cd Sport-Match-Backend

# 2. Crear la base de datos en PostgreSQL
#    CREATE DATABASE "Sportmatch";

# 3. Crear src/main/resources/application.properties (ver sección Configuración)

# 4. Ejecutar la aplicación
./mvnw spring-boot:run        # Windows: mvnw.cmd spring-boot:run
```

La API queda disponible en `http://localhost:8080` (puerto por defecto de Spring Boot).

## Configuración

Crea el archivo `src/main/resources/application.properties` a partir de la plantilla:

```properties
spring.application.name=Sportmatch
spring.datasource.url=${DB_URL:jdbc:postgresql://localhost:2026/Sportmatch}
spring.datasource.username=<usuario>
spring.datasource.password=<contraseña>
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
logging.file.name=logs/api.log
jwt.secret=<clave-secreta>
```

| Variable / propiedad | Descripción                                                              |
| -------------------- | ------------------------------------------------------------------------ |
| `DB_URL`             | URL JDBC de PostgreSQL. Si no se define, usa `localhost:2026`            |
| `spring.datasource.username` / `password` | Credenciales de la base de datos                    |
| `jwt.secret`         | Clave para firmar tokens                                                 |

> **Importante:** en el despliegue en EC2 hay que definir `DB_URL` con el endpoint de Amazon RDS, por ejemplo `jdbc:postgresql://<endpoint-rds>:5432/<base>`. Si no, la API intenta conectarse a `localhost` y falla al iniciar. No subas credenciales ni secretos al repositorio.

## Documentación de la API (Swagger)

Con la aplicación en ejecución:

- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## Endpoints

### Usuarios (`/usuarios`)

| Método | Ruta                          | Descripción                                |
| ------ | ----------------------------- | ------------------------------------------ |
| POST   | `/usuarios/registrar`         | Registrar una nueva cuenta de usuario      |
| POST   | `/usuarios/login`             | Autenticación por correo y contraseña      |
| GET    | `/usuarios/listar_usuarios`   | Listar usuarios activos                    |
| GET    | `/usuarios/listar_dto`        | Listar usuarios sin exponer credenciales   |

### Actividades (`/actividades`)

| Método | Ruta                                  | Descripción                                  |
| ------ | ------------------------------------- | -------------------------------------------- |
| POST   | `/actividades/registrar`              | Registrar y publicar una actividad deportiva |
| GET    | `/actividades/listar_disponibles`     | Listar actividades disponibles (entidad)     |
| GET    | `/actividades/listar_dto`             | Listar actividades en formato DTO            |
| GET    | `/actividades/deporte/{deporteId}`    | Filtrar actividades por deporte              |
| GET    | `/actividades/{id}`                   | Obtener el detalle de una actividad          |

### Participaciones (`/participaciones`)

| Método | Ruta                                       | Descripción                                        |
| ------ | ------------------------------------------ | -------------------------------------------------- |
| POST   | `/participaciones/unirse`                  | Solicitar inscripción en una actividad             |
| GET    | `/participaciones/actividad/{actividadId}` | Listar participantes de una actividad              |
| GET    | `/participaciones/jugador/{jugadorId}`     | Listar el historial de inscripciones de un jugador |

## Despliegue

- **API REST:** Spring Boot en una instancia Amazon EC2, puerto `8080`.
- **Base de datos:** Amazon RDS for PostgreSQL.

```bash
./mvnw clean package          # genera target/Sportmatch-0.0.1-SNAPSHOT.jar
DB_URL=jdbc:postgresql://<endpoint-rds>:5432/<base> java -jar target/Sportmatch-0.0.1-SNAPSHOT.jar
```

## Repositorios relacionados

- Landing Page: Sport-Match-Landing-Page (`semi896`)

## Equipo

| Integrante                              | Rol                    |
| --------------------------------------- | ---------------------- |
| Adrian Steven Pariona Robles            | Scrum Master           |
| Luis Antonio de Jesús Rodríguez Mendoza | Development Team       |
| Fabian Mathias Achulla Canales          | Development Team       |
| Ronel Wilfredo Rojas Alderete           | Development Team       |
| Diego Alejandro Arturo Baldeón Trigo    | Development Supervisor |
