FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app


COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests -B


FROM eclipse-temurin:21-jre

# Crear usuario y grupo de sistema (comandos compatibles con Debian)
RUN addgroup --system appgroup && adduser --system --ingroup appgroup --no-create-home appuser

WORKDIR /app


COPY --from=build /app/target/*.jar app.jar


RUN chown appuser:appgroup app.jar

USER appuser


EXPOSE 8080

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://pg-back-planetas-back-planetas.d.aivencloud.com:26997/defaultdb?sslmode=require
ENV SPRING_DATASOURCE_USERNAME=avnadmin
ENV SPRING_DATASOURCE_PASSWORD=AVNS_62G3Dgm7N4EwHQwcwRs


ENTRYPOINT ["java", \
            "-XX:+UseContainerSupport", \
            "-XX:MaxRAMPercentage=75.0", \
            "-Djava.security.egd=file:/dev/./urandom", \
            "-jar", "app.jar"]
