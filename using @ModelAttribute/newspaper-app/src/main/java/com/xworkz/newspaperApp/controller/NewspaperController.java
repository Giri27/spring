package com.xworkz.newspaperApp.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.newspaperApp.dto.NewspaperDTO;

@Component
@RequestMapping("/")
public class NewspaperController {

	public NewspaperController() {
		System.out.println(this.getClass().getSimpleName() +" bean created");
	}
	
	@RequestMapping("/submitnewspaper.news")
	String onSubmit(@ModelAttribute NewspaperDTO NewspaperDTO, Model model) {        //data binding
		System.out.println("Invoked onSubmit");
		
		
		model.addAttribute("NAME", NewspaperDTO.getNewspaperName());
		model.addAttribute("PRICE", NewspaperDTO.getPrice());
		model.addAttribute("LANGUAGE", NewspaperDTO.getLanguage());
		model.addAttribute("NUMBEROFPAGES", NewspaperDTO.getNoOfPages());
		
		return "/WEB-INF/newspaperDetails.jsp";
	}
	
	
}
