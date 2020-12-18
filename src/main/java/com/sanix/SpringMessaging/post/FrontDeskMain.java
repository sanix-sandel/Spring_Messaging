package com.sanix.SpringMessaging.post;

import com.sanix.SpringMessaging.config.BackOfficeConfiguration;
import com.sanix.SpringMessaging.config.FrontOfficeConfiguration;
import com.sanix.SpringMessaging.models.Mail;
import com.sanix.SpringMessaging.services.FrontDesk;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FrontDeskMain {
    public static void main(String [] args){
        ApplicationContext context=new AnnotationConfigApplicationContext(
                FrontOfficeConfiguration.class
        );

        FrontDesk frontDesk=context.getBean(FrontDesk.class);
        frontDesk.sendMail(new Mail("1234", "US", 1.5));
    }
}
