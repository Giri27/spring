package com.xworkz.cctv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {
	
	public static void main(String[] args) {
		
		String springConfigFile = "spring.xml";
		ApplicationContext springContainer = new ClassPathXmlApplicationContext(springConfigFile);
		System.out.println("springConatiner is created "+springContainer.hashCode());
		
		
		CCTV cctv = springContainer.getBean(CCTV.class);
		System.out.println(cctv);
		System.out.println(cctv.getBrand());
		System.out.println(cctv.getCameraSize());
		System.out.println(cctv.getPrice());
		System.out.println(cctv.getColor());
		
		cctv.record();
		cctv.autoDelete();
		
		String string = springContainer.getBean(String.class);
		System.out.println(string.hashCode());
		
		Byte byt = springContainer.getBean(Byte.class);
		System.out.println(byt.hashCode());
		
		Short shrt = springContainer.getBean(Short.class);
		System.out.println(shrt.hashCode());
		
		Integer integer = springContainer.getBean(Integer.class);
		System.out.println(integer.hashCode());
		
		Long lng = springContainer.getBean(Long.class);
		System.out.println(lng.hashCode());
		
		Double doub = springContainer.getBean(Double.class);
		System.out.println(doub.hashCode());
		
		Float flot = springContainer.getBean(Float.class);
		System.out.println(flot.hashCode());
		
		Character ch = springContainer.getBean(Character.class);
		System.out.println(ch.hashCode());
		
		Boolean bool = springContainer.getBean(Boolean.class);
		System.out.println(bool.hashCode());
		
	}

}
