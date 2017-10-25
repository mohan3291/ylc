package com.ylc.util;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ylc.model.Email;

@Service
public class SendEmail
{
	
	@Value("${ylc.email.username}")
	private String username;
	
	@Value("${ylc.email.password}")
	private String password;
	
	
	public  void sendOrderEMail(Email email){		

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("sureshkandimalla@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email.getTo()));
			message.setSubject(email.getSubject());
			message.setText(email.getMessage());
			message.isMimeType("text/html");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public  void sendEMail(String to){		

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("noreplay@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	 

	
	public static void main(String ar[]){
	//	SendEmail sendEmail=new SendEmail();	
	//	sendEmail.sendEmailViaSSL();
		//sendEmail.sendEMail();
	}
  
}