package com.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailService {
	
	@Autowired
	JavaMailSender mailSender;
	public void sendEmailToCustomer(String mailId,String name)
	{
		
		System.out.println("Entered into mailService method >>>>>");
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setTo(mailId);
		mailMessage.setSubject("MAil From CRM APP");
		mailMessage.setText("Dear"+name+", \n Thanks for registering with  us");
		mailSender.send(mailMessage);
		System.out.println("Exiting from mailservice loop");
	}
}
