package com.sena.scheduler.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class emailService {

	 @Autowired
	    private JavaMailSender mailSender;

	    public void sendEmail(SimpleMailMessage email) {
	        mailSender.send(email);
	    }
}
