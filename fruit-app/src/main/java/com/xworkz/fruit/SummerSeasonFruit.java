package com.xworkz.fruit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SummerSeasonFruit {

	@Value("Watermelon")
	private String fname;
	
	public SummerSeasonFruit() {
		System.out.println(this.getClass().getSimpleName()+ " Bean created");
	}

	public SummerSeasonFruit(String fname) {
		this.fname = fname;
	}

	public String getFname() {
		return fname;
	}

	@Override
	public String toString() {
		return "SummerSeasonFruit [fname=" + fname + "]";
	}
}
