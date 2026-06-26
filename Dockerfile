# ==========================================
# STAGE 1: Build
# ==========================================
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copiar pom.xml primero para aprovechar caché de capas de Docker
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el código fuente y compilar
COPY src ./src
RUN mvn clean package -DskipTests -B

# ==========================================
# STAGE 2: Runtime
# ==========================================
FROM eclipse-temurin:21-jre-alpine

# Crear usuario no root por seguridad
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

WORKDIR /app

# Copiar el JAR generado en la etapa de build
COPY --from=build /app/target/*.jar app.jar

# Cambiar propietario al usuario no root
RUN chown appuser:appgroup app.jar

USER appuser

# Exponer puerto
EXPOSE 8080

# Variables de entorno por defecto (sobreescribibles en tiempo de ejecución)
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/planetas_db
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=postgres

# Comando de inicio con opciones JVM optimizadas para contenedores
ENTRYPOINT ["java", \
            "-XX:+UseContainerSupport", \
            "-XX:MaxRAMPercentage=75.0", \
            "-Djava.security.egd=file:/dev/./urandom", \
            "-jar", "app.jar"]
