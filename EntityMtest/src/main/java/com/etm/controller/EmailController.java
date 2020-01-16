package com.etm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etm.service.EmailService;

@RestController
@Controller
public class EmailController {
	
	private Logger logger = LoggerFactory.getLogger(EmailController.class);
	
	@Autowired
	private EmailService mailserv;
	
	@GetMapping("/send")
	public void sendEmail() {
		try {
			mailserv.sendNotid("aa","aaa","aaa");
		} catch (MailException e) {
			
			logger.info("Error Sending Email : "+e.getMessage());
			// TODO: handle exception
		}
		
	}
}
