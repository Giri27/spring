package com.xworkz.newspaperApp.service;

import org.springframework.stereotype.Component;

import com.xworkz.newspaperApp.dto.NewspaperDTO;

@Component
public class NewspaperServiceImpl implements NewspaperService {

	public NewspaperServiceImpl() {
		System.out.println(this.getClass().getSimpleName()+ " created");
	}
	
	@Override
	public boolean validateNewspaperDTO(NewspaperDTO newspaperDTO) {
		System.out.println("Invoked validateNewspaperDTO");
		boolean flag = false;
		if(newspaperDTO.getNewspaperName() != null && newspaperDTO.getNewspaperName().isBlank()){
			flag = true;
		} else {
			flag = false;
			System.out.println("Invalid newspaperName");
			return flag;
		}
		if(newspaperDTO.getPrice() > 0){
			flag = true;
		} else {
			flag = false;
			System.out.println("Invalid newspaper price");
			return flag;
		}
		if(newspaperDTO.getLanguage() != null && newspaperDTO.getLanguage().isEmpty()){
			flag = true;
		} else {
			flag = false;
			System.out.println("Invalid newspaper language");
			return flag;
		}
		if(newspaperDTO.getNoOfPages() > 0){
			flag = true;
		} else {
			flag = false;
			System.out.println("Invalid number of pages");
			return flag;
		}
		
		return false;
	}

}
