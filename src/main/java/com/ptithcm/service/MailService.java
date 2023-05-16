package com.ptithcm.service;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailService {

	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl  mailSenderImpl = new JavaMailSenderImpl();
		mailSenderImpl.setHost("smtp.gmail.com");
		mailSenderImpl.setPort(587);
		mailSenderImpl.setUsername("huytn102030z@gmail.com");
		mailSenderImpl.setPassword("lyrjoqbbsjgducsi");
		
		Properties javaMailProperties = new Properties();
		
		javaMailProperties.put("mail.smtp.starttls.enable","true");
		javaMailProperties.put("mail.smtp.auth","true");
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.debug","true");
		javaMailProperties.put("mail.smtp.host", "smtp.gmail.com");
		javaMailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//		javaMailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		mailSenderImpl.setJavaMailProperties(javaMailProperties);
		
		return mailSenderImpl;
	}
	
}
