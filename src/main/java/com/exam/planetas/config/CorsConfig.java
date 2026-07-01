package com.exam.planetas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
public CorsFilter corsFilter() {

    CorsConfiguration corsConfiguration = new CorsConfiguration();

    // IMPORTANTE: usar patterns en lugar de allowedOrigins
    corsConfiguration.setAllowedOriginPatterns(List.of(
            "http://localhost:*",
            "http://127.0.0.1:*",
            "https://*.github.io",
            "*",
            "https://planetas-frontend.onrender.com"
    ));

    corsConfiguration.setAllowedMethods(List.of(
            "GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"
    ));

    corsConfiguration.setAllowedHeaders(List.of("*"));

    corsConfiguration.setAllowCredentials(false);

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfiguration);

    return new CorsFilter(source);
}
}
