package com.sanix.SpringMessaging.config;

import com.sanix.SpringMessaging.services.BackOfficeImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BackOfficeConfiguration {
    @Bean
    public BackOfficeImpl backOffice(){
        return new BackOfficeImpl();
    }
}
