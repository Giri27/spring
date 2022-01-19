package com.xworkz.newspaperApp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.newspaperApp.dto.NewspaperDTO;
import com.xworkz.newspaperApp.service.NewspaperService;

@Controller
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
			
			Map<String, String> map = this.newspaperService.map;
			
			model.addAttribute("messageForName", map.get("newspaperName"));
			model.addAttribute("messageForPrice", map.get("price"));
			model.addAttribute("messageForLanguage", map.get("language"));
			model.addAttribute("messageForPages", map.get("noOgPages"));
		}
				
		return "/welcome.jsp";
	}
	
	@RequestMapping("/searchNewspaper.news")
	public String onSearch(@RequestParam String searchNewspaper, Model model) {
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
		} else {
			model.addAttribute("searchValidationMessage", "Invalid newspaper, enter valid name");
		}
		return "/welcome.jsp";
	}
	
	@RequestMapping("/getAllNewspaper.news")
	public String onGetAllNewspaperClicked(Model model) {
		
		System.out.println("Invoked onGetAllNewspaperClicked");
		List<Object> allNewspaper = this.newspaperService.getAllNewspaper();
		model.addAttribute("ListOfNewspaper", allNewspaper);
		return "/welcome.jsp";
	}
	
	@RequestMapping("/updateNewspaper.news")
	public String onClickUpdate(@ModelAttribute NewspaperDTO newspaperDTO, @RequestParam(value="searchNewspaper", required=false) String searchNewspaper, Model model) {
		System.out.println("Invoked onClickUpdate()");
		boolean isUpdated = this.newspaperService.updateNewspaperEntityByName(newspaperDTO);
			if(isUpdated) {
				model.addAttribute("updateValidationMessage", "Newspaper Details Updated");
			} else {
				model.addAttribute("updateValidationMessage", "Enter valid data");
			} 
		return "/welcome.jsp";		
	}
	
	@RequestMapping("/deleteNewspaper.news")
	public String onClickDelete(@RequestParam(value="searchNewspaper", required=false) String searchNewspaper, Model model) {
		System.out.println("Invoked onClickDelete()" +searchNewspaper);
		
		if(this.newspaperService.validateNewspaperName(searchNewspaper)) {
			boolean isDeleted = this.newspaperService.deleteNewspaperEntity(searchNewspaper);
			if(isDeleted) {
				model.addAttribute("deleteValidationMessage", "Newspaper has been deleted");
			} else {
				model.addAttribute("deleteValidationMessage", "Data is not available, enter valid newspaper name");
			}
		} else {
			model.addAttribute("deleteValidationMessage", "Enter valid newspaper name");
		}
		return "/welcome.jsp";
	}
	/*@RequestMapping("/searchLanguage.news")
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
	}*/
	
	
	
}
