package com.sanix.SpringMessaging.post;

import com.sanix.SpringMessaging.config.BackOfficeConfiguration;
import com.sanix.SpringMessaging.models.Mail;
import com.sanix.SpringMessaging.services.BackOffice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BackOfficeMain {

    public static void main(String[] args){
        ApplicationContext context=new AnnotationConfigApplicationContext(
                BackOfficeConfiguration.class
        );

        BackOffice backOffice=context.getBean(BackOffice.class);
        Mail mail= backOffice.receiveMail();
        System.out.println("Mail #"+mail.getMailId()+" received");
    }
}
