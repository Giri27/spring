package com.xworkz.newspaperApp;

import org.springframework.stereotype.Component;

@Component
public class Newspaper {
	
	public Newspaper() {
		System.out.println(this.getClass().getSimpleName() +" bean created");
	}
	
	

}
