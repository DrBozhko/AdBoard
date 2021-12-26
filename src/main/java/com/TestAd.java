package com;

import com.config.ConfigApp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class TestAd {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

        JavaMailSenderImpl sender = context.getBean(JavaMailSenderImpl.class);

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("Valevskii.a@gmail.com");
        message.setSubject("Greetings");
        message.setText("Hello");

        sender.send(message);
    }
}
