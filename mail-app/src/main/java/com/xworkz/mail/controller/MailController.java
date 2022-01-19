package com.xworkz.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.mail.service.MailService;

@Controller
@RequestMapping("/")
public class MailController {
	
	@Autowired
	private MailService mailService;
	
	public MailController() {
		System.out.println(this.getClass().getSimpleName() + " bean Created");
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
	}
	
	@RequestMapping("/sendMail.mail")
	public String onClickSend(@RequestParam String to, @RequestParam 
			String subject, @RequestParam String message, Model model) {
		System.out.println("Invoked onClickSend()");
		
		boolean result = this.mailService.sendMail(to, subject, message);
		if(result) {
			model.addAttribute("message", "Mail Sent");
		} else {
			model.addAttribute("message", "Mail Not Sent");
		}
		return "/index.jsp";
	}

}
