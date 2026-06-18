package com.sistema.sistematomahorarios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/**")
                        .allowedOrigins(
                                "http://localhost:5173",
                                "https://taller-aplicado-programacion-frontend-5m8ur3n5v.vercel.app",
                                "https://taller-aplicado-programacion-frontend-4xsimwdg1.vercel.app")
                        .allowedMethods("*")
                        .allowedHeaders("*");
            }
        };
    }
}