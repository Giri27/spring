package com.xworkz.tvremote.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.xworkz.tvremote.dao.TVRemoteDAO;

public class TVRTester {
	
	public static void main(String[] args) {
		
		String springConfigFile = "applicationContext.xml";
		ApplicationContext springContainer = new ClassPathXmlApplicationContext(springConfigFile);
		
		TVRemote tvRemote = new TVRemote();
		tvRemote.setName("LG");
		tvRemote.setPrice(250.0);
		tvRemote.setColor("Black");
		tvRemote.setNoOfCells(2);
		tvRemote.setPowerButtonWorking(true);
		
		
		TVRemoteDAO dao = springContainer.getBean(TVRemoteDAO.class);
		dao.addTVRemoteEntity(tvRemote);
		
		//LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		ClassPathXmlApplicationContext cpxac = (ClassPathXmlApplicationContext)springContainer;
		cpxac.close();
	}
}
