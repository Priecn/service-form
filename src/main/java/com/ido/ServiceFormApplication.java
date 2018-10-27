package com.ido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ServiceFormApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceFormApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/v1/province/**").allowedOrigins("http://localhost:4200");
                registry.addMapping("/v1/vendor/**").allowedOrigins("http://localhost:4200");
                registry.addMapping("/v1/company/category/**").allowedOrigins("http://localhost:4200");
            }
        };
    }
}