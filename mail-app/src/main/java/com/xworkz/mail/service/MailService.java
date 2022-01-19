package com.xworkz.mail.service;

public interface MailService {
	
	boolean sendMail(String to, String subject, String message);

}
