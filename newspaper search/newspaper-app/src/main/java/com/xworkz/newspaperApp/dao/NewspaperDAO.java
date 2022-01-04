package com.xworkz.newspaperApp.dao;

import com.xworkz.newspaperApp.entity.NewspaperEntity;

public interface NewspaperDAO {
	
	boolean saveNewspaperEntity(NewspaperEntity newspaperEntity);

	NewspaperEntity getNewspaperEntity(String newspaperName);
}
