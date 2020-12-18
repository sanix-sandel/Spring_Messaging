package com.sanix.SpringMessaging.services;

import com.sanix.SpringMessaging.models.Mail;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

public class BackOfficeImpl implements BackOffice{

    @Override
    public Mail receiveMail() {
        ConnectionFactory cf= new ActiveMQConnectionFactory("tcp://localhost:61616");
        Destination destination =new ActiveMQQueue();

        Connection conn=null;
        try{
            conn=cf.createConnection();
            Session session=conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer=session.createConsumer(destination);

            conn.start();
            MapMessage message=(MapMessage) consumer.receive();
            Mail mail=new Mail(message.getString("mailId"), message.getString("country"),
                    message.getDouble("weight"));
            session.close();
            return mail;
        }catch(JMSException ex){
            throw new RuntimeException(ex);
        }finally{
            if(conn!=null){
                try{
                    conn.close();
                }catch(JMSException e){}
            }
        }
    }
}
