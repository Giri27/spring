package com.xworkz.newspaperApp.service;

import com.xworkz.newspaperApp.dto.NewspaperDTO;

public interface NewspaperService {
	
	boolean validateNewspaperDTO(NewspaperDTO newspaperDTO);
	
	boolean saveNewspaperDTO(NewspaperDTO newspaperDTO);
	
	boolean validateNewspaperName(String newspaperName);

	NewspaperDTO getNewspaperDTO(String newspaperName);
	
	boolean validateNewspaperLanguage(String language);
	NewspaperDTO getNewspaper(String language);
}
