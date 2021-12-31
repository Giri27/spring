package com.xworkz.newspaperApp.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class NewspaperController {

	public NewspaperController() {
		System.out.println(this.getClass().getSimpleName() +" bean created");
	}
	
	@RequestMapping("/sub.news")
	void handleFirstReq() {
		System.out.println("Invoked handleFirstReq");
	}
	
	@RequestMapping("/sub2.news")
	void handleFirstReq2() {
		System.out.println("Invoked handleFirstReq2");
	}

}
