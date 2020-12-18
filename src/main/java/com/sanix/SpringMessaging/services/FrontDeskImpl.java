package com.sanix.SpringMessaging.services;

import com.sanix.SpringMessaging.models.Mail;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

public class FrontDeskImpl implements FrontDesk{

    @Override
    public void sendMail(Mail mail) {
        ConnectionFactory cf=new ActiveMQConnectionFactory("tcp://localhost:61616");
        Destination destination=new ActiveMQQueue("mail.queue");

        Connection conn=null;

        try{
            conn=cf.createConnection();
            Session session=conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer=session.createProducer(destination);

            MapMessage message=session.createMapMessage();
            message.setString("mailId", mail.getMailId());
            message.setString("country", mail.getCountry());
            message.setDouble("weight", mail.getWeight());
            producer.send(message);

            session.close();
        }catch (JMSException ex){
            throw new RuntimeException(ex);
        }finally {
            if(conn!=null){
                try{
                    conn.close();
                }catch(JMSException ex){}
            }
        }
    }
}
