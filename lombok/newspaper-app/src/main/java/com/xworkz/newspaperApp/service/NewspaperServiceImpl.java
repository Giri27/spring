package com.xworkz.newspaperApp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.newspaperApp.dao.NewspaperDAO;
import com.xworkz.newspaperApp.dto.NewspaperDTO;
import com.xworkz.newspaperApp.entity.NewspaperEntity;

@Service
public class NewspaperServiceImpl implements NewspaperService {

	
	
	@Autowired
	private NewspaperDAO newspaperDAO;
	
	public NewspaperServiceImpl() {
		System.out.println(this.getClass().getSimpleName()+ " created");
	}
	
	@Override
	public boolean validateNewspaperDTO(NewspaperDTO newspaperDTO) {
		System.out.println("Invoked validateNewspaperDTO");
		boolean flag = false;
		if(newspaperDTO.getNewspaperName() != null && !newspaperDTO.getNewspaperName().isBlank()){
			flag = true;
		} else {
			flag = false;
			System.out.println("Invalid newspaperName");
			map.put("newspaperName", "Invalid newspaper name");
			return flag;
		}
		if(newspaperDTO.getPrice() > 0){
			flag = true;
		} else {
			flag = false;
			System.out.println("Invalid newspaper price");
			map.put("price", "Invalid price");
			return flag;
		}
		if(newspaperDTO.getLanguage() != null && !newspaperDTO.getLanguage().isEmpty()){
			flag = true;
		} else {
			flag = false;
			System.out.println("Invalid newspaper language");
			map.put("language", "Invalid language");
			return flag;
		}
		if(newspaperDTO.getNoOfPages() > 0){
			flag = true;
		} else {
			flag = false;
			System.out.println("Invalid number of pages");
			map.put("noOfPages", "Invalid Number of pages");
			return flag;
		}
		
		return flag;
	}

	@Override
	public boolean saveNewspaperDTO(NewspaperDTO newspaperDTO) {
		NewspaperEntity newspaperEntity = new NewspaperEntity();
		
		BeanUtils.copyProperties(newspaperDTO, newspaperEntity);  //copy all the properties from dto to entity		
		boolean result = this.newspaperDAO.saveNewspaperEntity(newspaperEntity);		
		return result;
	}

	@Override
	public boolean validateNewspaperName(String newspaperName) {
		System.out.println("Invoked validateNewspaperName");
		boolean flag = false;
		if(newspaperName != null && !newspaperName.isBlank()){
			flag = true;
			return flag;
		} else {
			flag = false;
			System.out.println("Invalid newspaperName");
			return flag;
		}
	}

	@Override
	public NewspaperDTO getNewspaperDTO(String newspaperName) {
		System.out.println("Invoked getNewspaperDTO");
		NewspaperEntity entity = this.newspaperDAO.getNewspaperEntity(newspaperName);
		if(entity != null) {
			NewspaperDTO dto = new NewspaperDTO(); 
			BeanUtils.copyProperties(entity, dto);
			return dto;
		} else {
			return null;
		}
	}

	/*
	 * @Override public boolean validateNewspaperLanguage(String language) {
	 * System.out.println("Invoked validateNewspaperLanguage"); boolean flag =
	 * false; if(language != null && !language.isBlank()){ flag = true; return flag;
	 * } else { flag = false; System.out.println("Invalid language"); return flag; }
	 * }
	 * 
	 * @Override public NewspaperDTO getNewspaper(String language) {
	 * System.out.println("Invoked getNewspaper"); NewspaperEntity entity =
	 * this.newspaperDAO.getNewspaperEntityByLang(language); if(entity != null) {
	 * NewspaperDTO dto = new NewspaperDTO(); BeanUtils.copyProperties(entity, dto);
	 * return dto; } else { return null; } }
	 */
}
