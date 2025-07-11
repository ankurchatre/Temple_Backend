package com.main.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // This resolves to /home/render/uploads/ or C:/Users/yourname/uploads/
        String path = Paths.get(System.getProperty("user.home"), "uploads").toUri().toString();
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations(path);
    }
}
