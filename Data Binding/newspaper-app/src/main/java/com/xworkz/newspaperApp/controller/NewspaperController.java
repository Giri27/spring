package com.xworkz.newspaperApp.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class NewspaperController {

	public NewspaperController() {
		System.out.println(this.getClass().getSimpleName() +" bean created");
	}
	
	@RequestMapping("/submitnewspaper.news")
	String onSubmit(@RequestParam String newspaperName,@RequestParam double price,@RequestParam String language,@RequestParam int noOfPages, Model model) {        //data binding
		System.out.println("Invoked onSubmit");
		System.out.println("Newspaper name "+newspaperName);
		System.out.println("Price " +price);
		System.out.println("Language " +language);
		System.out.println("Number of pages " +noOfPages);
		
		model.addAttribute("NAME", newspaperName);
		model.addAttribute("PRICE", price);
		model.addAttribute("LANGUAGE", language);
		model.addAttribute("NUMBEROFPAGES", noOfPages);
		
		return "/WEB-INF/newspaperDetails.jsp";
	}
	
	
}
