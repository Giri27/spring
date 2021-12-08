package com.xworkz.fruit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FruitTester {
	
	public static void main(String[] args) {
		
		String springConfigFile = "fruit.xml";
		ApplicationContext springContainer = new ClassPathXmlApplicationContext(springConfigFile);
		System.out.println("Spring container is created " +springContainer);
		
		Fruit fruit = springContainer.getBean(Fruit.class);
		System.out.println(fruit.toString());
		
		SummerSeasonFruit ssf = springContainer.getBean(SummerSeasonFruit.class);
		System.out.println(ssf);
		
		Connection connection = springContainer.getBean(Connection.class);
		System.out.println(connection);
	}

}
