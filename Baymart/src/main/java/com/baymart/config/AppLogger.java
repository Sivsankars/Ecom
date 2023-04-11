package com.baymart.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppLogger {
    
    @Bean
    public Logger getLogger() {
        return LoggerFactory.getLogger("MyAppLogger");
    }
}