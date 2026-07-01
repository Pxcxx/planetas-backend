package com.exam.planetas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server; // <-- Importante
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        // Servidor de Producción (Render)
        Server prodServer = new Server();
        prodServer.setUrl("https://back-planetas-lastest.onrender.com"); // <-- REEMPLAZA CON TU URL DE RENDER
        prodServer.setDescription("Servidor de Producción en Render");

        // Servidor Local (Para cuando programas en tu PC)
        Server localServer = new Server();
        localServer.setUrl("http://localhost:8080");
        localServer.setDescription("Servidor de Desarrollo Local");

        return new OpenAPI()
                .info(new Info()
                        .title("API de Planetas")
                        .description("API REST para gestión de planetas del sistema solar y más allá")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo")
                                .email("dev@exam.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")))
                .servers(List.of(prodServer, localServer)); // <-- Agrega los servidores aquí
    }
}