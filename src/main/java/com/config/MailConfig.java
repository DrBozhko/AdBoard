package com.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource("classpath:mail.properties")
public class MailConfig implements EnvironmentAware {
    private Environment environment;

    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();

        String host = environment.getRequiredProperty("mail.host");
        String port = environment.getRequiredProperty("mail.port");
        String username = environment.getRequiredProperty("mail.username");
        String password = environment.getRequiredProperty("mail.password");
        String protocol = environment.getRequiredProperty("mail.transport.protocol");
        String smtp = environment.getRequiredProperty("mail.transport.smtp");
        String auth = environment.getRequiredProperty("mail.transport.auth");
        String starttls = environment.getRequiredProperty("mail.stmp.starttls.enable");
        String transportEnable = environment.getRequiredProperty("mail.transport.enable");

        sender.setHost(host);
        sender.setPort(Integer.parseInt(port));
        sender.setUsername(username);
        sender.setPassword(password);

        Properties properties = sender.getJavaMailProperties();
        properties.put(protocol, smtp);
        properties.put(auth, Boolean.valueOf(transportEnable));
        properties.put(starttls, Boolean.valueOf(transportEnable));

        return sender;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
