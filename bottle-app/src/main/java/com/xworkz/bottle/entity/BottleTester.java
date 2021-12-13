package com.xworkz.bottle.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.bottle.dao.BottleDAO;

public class BottleTester {
	
	public static void main(String[] args) {
		
		String springConfigFile = "bottleSpring.xml";
		ApplicationContext springContainer = new ClassPathXmlApplicationContext(springConfigFile);
		
		BottleEntity bottleEntity = new BottleEntity();
		bottleEntity.setBbrand("Decathlon");
		bottleEntity.setBtype("Plastic");
		bottleEntity.setPrice(180.00);
		
		BottleDAO dao = springContainer.getBean(BottleDAO.class);
		dao.addBottleEntity(bottleEntity);
		
		ClassPathXmlApplicationContext classPathXmlApplicationContext = (ClassPathXmlApplicationContext) springContainer;
		classPathXmlApplicationContext.close();
	}

}
