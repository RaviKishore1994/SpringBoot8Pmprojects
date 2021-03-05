package com.pack.service;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
	JavaMailSender   sender;
	Logger  LOG=Logger.getLogger(EmailService.class);
	
	public   void   sendEmail(String  toAddress, String  username) {
		SimpleMailMessage  message=new  SimpleMailMessage();
		String  text="Dear  "+username+", \n You are successfully  registerd with this site\n Regards\n Support Team";
		message.setTo(toAddress);
		message.setSubject("A Test Mail from Boot APP");
		message.setText(text);
		message.setSentDate(new java.util.Date());
		try {
			sender.send(message);
			LOG.log(Level.INFO, "Email has been sent successfully");
		}catch(Exception  e) {
			LOG.log(Level.ERROR, e.getMessage());
		}

	}
}
