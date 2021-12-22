package com.xworkz.bottle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.bottle.dao.BottleDAO;
import com.xworkz.bottle.entity.BottleEntity;

@Component
public class BottleServiceImpl implements BottleService {

	@Autowired
	private BottleDAO bottleDAO;
	
	public BottleServiceImpl() {
		System.out.println(this.getClass().getSimpleName()+ " bean created");
	}

	@Override
	public boolean validateBottleEntity(BottleEntity bottleEntity) {

		System.out.println("Invoked validateBottleEntity");
		boolean flag = false;
		
		//String bbrand = bottleEntity.getBbrand();
		//flag = !bbrand.isEmpty() && bbrand != null ? true : false; // using  ternary operator 
		
		if(!bottleEntity.getBbrand().isEmpty() && bottleEntity.getBbrand() != null) {
			flag = true;
		} else {
			flag = false;
			System.out.println("Bottle Brand name cannot be empty");
			return flag;
		}
		if(!bottleEntity.getBtype().isEmpty() && bottleEntity.getBtype() != null) {
			flag = true;
		} else {
			flag = false;
			System.out.println("Bottle type cannot be empty");
			return flag;
		}
		if(bottleEntity.getPrice() > 0) {
			flag = true;
		} else {
			flag = false;
			System.out.println("Bottle price cannot be zero");
			return flag;
		} 
		
		if(flag) {
			System.out.println("All data has been validated");
			//BottleService bottleService = new BottleServiceImpl();
			//boolean validate = bottleService.validateBottleEntity(bottleEntity);
			this.bottleDAO.addBottleEntity(bottleEntity);
			return flag;
		} else {
			System.out.println("Invalid data");
			return flag;
		}
	}

}
