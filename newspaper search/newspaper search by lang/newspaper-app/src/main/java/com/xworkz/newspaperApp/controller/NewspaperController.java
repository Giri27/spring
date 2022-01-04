package com.xworkz.newspaperApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.newspaperApp.dto.NewspaperDTO;
import com.xworkz.newspaperApp.service.NewspaperService;

@Component
@RequestMapping("/")
public class NewspaperController {
	
	@Autowired
	private NewspaperService newspaperService;

	public NewspaperController() {
		System.out.println(this.getClass().getSimpleName() +" bean created");
	}
	
	@RequestMapping("/submitnewspaper.news")
	String onSubmit(@ModelAttribute NewspaperDTO NewspaperDTO, Model model) {        //data binding
		System.out.println("Invoked onSubmit");
		
		if(this.newspaperService.validateNewspaperDTO(NewspaperDTO)) {
			boolean isSaved = this.newspaperService.saveNewspaperDTO(NewspaperDTO);
			if(isSaved) {
				model.addAttribute("validationMessage", "Newspaper details has been saved");
			} else {
				model.addAttribute("validationMessage", "could not save details enter data again");
			}
		} else {
			model.addAttribute("validationMessage", "Invalid data Enter again");
		}
				
		return "/welcome.jsp";
	}
	
	@RequestMapping("/searchNewspaper.news")
	public String onSearch(@RequestParam String searchNewspaper, String searchLanguage, Model model) {
		System.out.println("Invoked onSearch");
		
		if(this.newspaperService.validateNewspaperName(searchNewspaper)) {
			NewspaperDTO newspaperDTO = this.newspaperService.getNewspaperDTO(searchNewspaper);
			if(newspaperDTO != null) {
				model.addAttribute("NEWSPAPERNAME", newspaperDTO.getNewspaperName());
				model.addAttribute("PRICE", newspaperDTO.getPrice());
				model.addAttribute("LANGUAGE", newspaperDTO.getLanguage());
				model.addAttribute("NUMBEROFPAGES", newspaperDTO.getNoOfPages());
				
				return "/welcome.jsp";
			} else {
				model.addAttribute("NOTFOUND", "newspaper not found, Enter valid newspaper name");
			}
		} 
		/*else if(this.newspaperService.validateNewspaperLanguage(searchLanguage)) {
			NewspaperDTO newspaperDTO = this.newspaperService.getNewspaper(searchLanguage);
			if(newspaperDTO != null) {
				model.addAttribute("NEWSPAPERNAME", newspaperDTO.getNewspaperName());
				model.addAttribute("PRICE", newspaperDTO.getPrice());
				model.addAttribute("LANGUAGE", newspaperDTO.getLanguage());
				model.addAttribute("NUMBEROFPAGES", newspaperDTO.getNoOfPages());
				
				return "/welcome.jsp";
			} else {
				model.addAttribute("NOTFOUND", "newspaper not found, Enter valid newspaper language");
				return "/welcome.jsp";
			}
		}*/
		
		else {
			model.addAttribute("searchValidationMessage", "Invalid newspaper, enter valid name");
		}
		return "/welcome.jsp";
	}
	
	@RequestMapping("/searchLanguage.news")
	public String onSearchByLang(@RequestParam String searchLanguage, Model model) {
		System.out.println("Invoked onSearchByLanguage");
		
		if(this.newspaperService.validateNewspaperLanguage(searchLanguage)) {
			NewspaperDTO newspaperDTO = this.newspaperService.getNewspaper(searchLanguage);
			if(newspaperDTO != null) {
				model.addAttribute("NEWSPAPERNAME", newspaperDTO.getNewspaperName());
				model.addAttribute("PRICE", newspaperDTO.getPrice());
				model.addAttribute("LANGUAGE", newspaperDTO.getLanguage());
				model.addAttribute("NUMBEROFPAGES", newspaperDTO.getNoOfPages());
				
				return "/welcome.jsp";
			} else {
				model.addAttribute("NOTFOUND", "newspaper not found, Enter valid newspaper language");
				return "/welcome.jsp";
			}
		} else {
			model.addAttribute("searchValidationMessageForLang", "Invalid language, enter valid name");
		}
		return "/welcome.jsp";
	}
	
	
}
