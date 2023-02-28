package com.example.sportmeeting1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //跨域配置
        //允许localhost:8080端口访问所有文件
        registry.addMapping("/**").allowedOrigins("http://localhost:8081");
    }
}