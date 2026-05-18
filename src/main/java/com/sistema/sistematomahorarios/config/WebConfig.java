package com.sistema.sistematomahorarios.config;

import com.sistema.sistematomahorarios.security.RolInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private RolInterceptor rolInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(rolInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/auth/**"); // login nunca necesita rol
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("*")
                .allowedHeaders("*");
    }
}