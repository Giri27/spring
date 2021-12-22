package com.xworkz.bottle.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.bottle.dao.BottleDAO;
import com.xworkz.bottle.service.BottleService;
import com.xworkz.bottle.service.BottleServiceImpl;

public class BottleTester {
	
	public static void main(String[] args) {
		
		String springConfigFile = "bottleSpring.xml";
		ApplicationContext springContainer = new ClassPathXmlApplicationContext(springConfigFile);
		
		BottleEntity bottleEntity = new BottleEntity();
		bottleEntity.setBbrand("Cello");
		bottleEntity.setBtype("");
		bottleEntity.setPrice(180.00);
		
		BottleService bottleService = springContainer.getBean(BottleService.class);
		boolean result = bottleService.validateBottleEntity(bottleEntity);
		if(result) {
			System.out.println("data saved");
		} else {
			System.out.println("data not saved");
		}
		
		ClassPathXmlApplicationContext classPathXmlApplicationContext = (ClassPathXmlApplicationContext) springContainer;
		classPathXmlApplicationContext.close();
	}

}
