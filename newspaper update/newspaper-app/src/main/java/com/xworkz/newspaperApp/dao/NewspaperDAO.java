package com.xworkz.newspaperApp.dao;

import java.util.List;

import com.xworkz.newspaperApp.dto.NewspaperDTO;
import com.xworkz.newspaperApp.entity.NewspaperEntity;

public interface NewspaperDAO {
	
	boolean saveNewspaperEntity(NewspaperEntity newspaperEntity);

	NewspaperEntity getNewspaperEntity(String newspaperName);
	
	//NewspaperEntity getNewspaperEntityByLang(String language);

	List<NewspaperEntity> getAllNewspaper();
	
	boolean deleteNewspaperEntity(String newspaperName);
	
	boolean updateNewspaperEntityByName(NewspaperDTO newspaperDTO);
}
