package com.sanix.SpringMessaging.config;

import com.sanix.SpringMessaging.services.FrontDeskImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FrontOfficeConfiguration {

    @Bean
    public FrontDeskImpl frontDesk(){
        return new FrontDeskImpl();
    }
}
