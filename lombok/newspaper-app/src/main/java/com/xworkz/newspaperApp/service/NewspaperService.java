package com.xworkz.newspaperApp.service;

import java.util.HashMap;
import java.util.Map;

import com.xworkz.newspaperApp.dto.NewspaperDTO;

public interface NewspaperService {
	
	Map<String, String> map = new HashMap<String, String>();
	
	boolean validateNewspaperDTO(NewspaperDTO newspaperDTO);
	
	boolean saveNewspaperDTO(NewspaperDTO newspaperDTO);
	
	boolean validateNewspaperName(String newspaperName);

	NewspaperDTO getNewspaperDTO(String newspaperName);
	
	//boolean validateNewspaperLanguage(String language);
	//NewspaperDTO getNewspaper(String language);
}
