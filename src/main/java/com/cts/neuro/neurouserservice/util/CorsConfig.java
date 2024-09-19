//package com.cts.neuro.neurouserservice.util;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class CorsConfig {
//
//    protected static final String[] ALLOWED_ORIGINS = new String[] { "http://localhost:4200" };
//    protected static final String[] ALLOWED_METHODS = new String[] { "GET", "POST", "PUT", "DELETE" };
//    @Bean
//    public WebMvcConfigurer configure(){
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins(ALLOWED_ORIGINS)
//                        .allowedMethods(ALLOWED_METHODS);
//            }
//        };
//    }
//}
