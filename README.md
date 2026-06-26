# 🪐 API REST - CRUD de Planetas

API RESTful desarrollada con Spring Boot 3 y PostgreSQL para la gestión de planetas.

---

## 📋 Descripción

Este proyecto implementa un CRUD completo de planetas, siguiendo una arquitectura por capas limpia y principios SOLID. Incluye validación de datos, manejo global de excepciones, documentación Swagger y soporte CORS.

---

## 🛠 Tecnologías

| Tecnología          | Versión   |
|---------------------|-----------|
| Java                | 21        |
| Spring Boot         | 3.2.5     |
| Maven               | 3.9+      |
| PostgreSQL          | 15/16     |
| Spring Data JPA     | 3.x       |
| Spring Validation   | 3.x       |
| Lombok              | 1.18+     |
| SpringDoc OpenAPI   | 2.5.0     |

---

## ✅ Requisitos previos

- Java 21 instalado
- Maven 3.9+ instalado
- PostgreSQL 15 o 16 corriendo localmente
- (Opcional) Docker y Docker Compose

---

## ⚙️ Configuración PostgreSQL

### 1. Crear base de datos

```sql
CREATE DATABASE planetas_db;
```

### 2. Verificar usuario y contraseña

Por defecto el proyecto usa:
- **Usuario:** `postgres`
- **Contraseña:** `postgres`
- **Puerto:** `5432`

Puedes modificar estos valores en `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/planetas_db
spring.datasource.username=postgres
spring.datasource.password=postgres
```

---

## 🚀 Cómo ejecutar

### Opción A — Maven (local)

```bash
# Clonar el repositorio
git clone https://github.com/tu-usuario/planetas.git
cd planetas

# Compilar y ejecutar
mvn spring-boot:run
```

### Opción B — JAR

```bash
mvn clean package -DskipTests
java -jar target/planetas-1.0.0.jar
```

### Opción C — Docker Compose

```bash
docker-compose up --build
```

La aplicación iniciará en: `http://localhost:8080`

---

## 📖 Documentación Swagger

Una vez iniciada la aplicación, accede a:

```
http://localhost:8080/swagger-ui/index.html
```

o

```
http://localhost:8080/swagger-ui.html
```

---

## 🔗 Endpoints disponibles

| Método | URL                        | Descripción                  |
|--------|----------------------------|------------------------------|
| GET    | `/api/planetas`            | Listar todos los planetas    |
| GET    | `/api/planetas/{id}`       | Buscar planeta por ID        |
| POST   | `/api/planetas`            | Crear un nuevo planeta       |
| PUT    | `/api/planetas/{id}`       | Actualizar un planeta        |
| DELETE | `/api/planetas/{id}`       | Eliminar un planeta          |

---

## 📦 Ejemplos de uso

### Crear planeta (POST)

```bash
curl -X POST http://localhost:8080/api/planetas \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Kepler-452b",
    "diametro": 17860.0,
    "masa": 2.16e25,
    "distanciaSol": 1.4e12,
    "habitantes": 0,
    "tieneLunas": false
  }'
```

### Listar planetas (GET)

```bash
curl http://localhost:8080/api/planetas
```

### Buscar por ID (GET)

```bash
curl http://localhost:8080/api/planetas/1
```

### Actualizar planeta (PUT)

```bash
curl -X PUT http://localhost:8080/api/planetas/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Mercurio Actualizado",
    "diametro": 4879.4,
    "masa": 3.3011e23,
    "distanciaSol": 57900000,
    "habitantes": 0,
    "tieneLunas": false
  }'
```

### Eliminar planeta (DELETE)

```bash
curl -X DELETE http://localhost:8080/api/planetas/1
```

---

## 📐 Estructura del proyecto

```
src
└── main
    ├── java/com/exam/planetas
    │   ├── controller        # PlanetaController (REST endpoints)
    │   ├── service           # PlanetaService (interfaz)
    │   │   └── impl          # PlanetaServiceImpl (lógica de negocio)
    │   ├── repository        # PlanetaRepository (JPA)
    │   ├── entity            # Planeta (entidad JPA)
    │   ├── dto               # PlanetaRequest / PlanetaResponse
    │   ├── mapper            # PlanetaMapper (conversión manual)
    │   ├── exception         # ResourceNotFoundException / GlobalExceptionHandler
    │   └── config            # CorsConfig / OpenApiConfig
    └── resources
        ├── application.properties
        ├── schema.sql
        └── data.sql
```

---

## 📸 Capturas esperadas

Al ejecutar la aplicación correctamente deberías ver:

1. **Consola Spring Boot** — arranque exitoso en el puerto 8080
2. **Swagger UI** — documentación interactiva en `/swagger-ui/index.html`
3. **GET /api/planetas** — lista de 12 planetas precargados en formato JSON
4. **POST /api/planetas** — planeta creado con status `201 Created`
5. **GET /api/planetas/999** — respuesta de error con status `404 Not Found` en JSON

---

## 🐳 Variables de entorno Docker

| Variable                    | Valor por defecto                          |
|-----------------------------|--------------------------------------------|
| `SPRING_DATASOURCE_URL`     | `jdbc:postgresql://db:5432/planetas_db`    |
| `SPRING_DATASOURCE_USERNAME`| `postgres`                                 |
| `SPRING_DATASOURCE_PASSWORD`| `postgres`                                 |

---

## 📄 Licencia

MIT License — libre para uso educativo y comercial.
