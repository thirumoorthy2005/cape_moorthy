package com.example.demo;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootApplication
public class MailDemomApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailDemomApplication.class, args);
		
		m1();
	}
	
	public static void m1() {

		String host = "smtp.gmail.com";
		int port = 587;
		String userName = "username@gmail.com*******************";
		String password = "password***************";

		String mailTo = "@gamil.com*************";
		String subject = "welcome cape";
		
		
 		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		
		sender.setHost(host);
		sender.setPort(port);
		sender.setUsername(userName);
		sender.setPassword(password);
	    
		Properties props = sender.getJavaMailProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	    

		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setTo(mailTo);
			helper.setSubject(subject);
			helper.setText("test test");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		sender.send(message);
	}

}
