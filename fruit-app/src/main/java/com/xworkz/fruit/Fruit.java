package com.xworkz.fruit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component 
public class Fruit {
	
	//@Value("Orange")
	private String name;
	//@Value("All")
	private String season;
	//@Value("60.0")
	private double pricePerKg;
	//@Value("Oragnge")
	private String color;
	private SummerSeasonFruit summerSeasonFruit;

	/*
	 * public Fruit() { System.out.println("Default "+
	 * this.getClass().getSimpleName() +" bean created"); }
	 */
	/*
	 * public Fruit(@Value("Grapes") String name, @Value("All") String
	 * season, @Value("100.00") double pricePerKg, @Value("Green") String color) {
	 * //constructor initialization System.out.println("Parameterized "+
	 * this.getClass().getSimpleName() +" bean created"); this.name = name;
	 * this.season = season; this.pricePerKg = pricePerKg; this.color = color; }
	 */
	
	public Fruit(@Value("Grapes") String name, @Value("All") String season, @Value("100.00") double pricePerKg, @Value("Green") String color, @Autowired SummerSeasonFruit summerSeasonFruit) {
		System.out.println("Parameterized "+ this.getClass().getSimpleName() +" bean created");
		this.name = name;
		this.season = season;
		this.pricePerKg = pricePerKg;
		this.color = color;
		this.summerSeasonFruit = summerSeasonFruit;
	}

	public String getName() {
		return name;
	}
	
	@Value("Apple")   //setter initialization
	public void setName(String name) {
		this.name = name;
	}
	public String getSeason() {
		return season;
	}
	
	@Value("All")
	public void setSeason(String season) {
		this.season = season;
	}
	public double getPricePerKg() {
		return pricePerKg;
	}
	
	@Value("140.0")
	public void setPricePerKg(double pricePerKg) {
		this.pricePerKg = pricePerKg;
	}
	public String getColor() {
		return color;
	}
	
	@Value("Red")
	public void setColor(String color) {
		this.color = color;
	}
	
	public SummerSeasonFruit getSummerSeasonFruit() {
		return summerSeasonFruit;
	}
	@Autowired
	public void setSummerSeasonFruit(SummerSeasonFruit summerSeasonFruit) {
		this.summerSeasonFruit = summerSeasonFruit;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", season=" + season + ", pricePerKg=" + pricePerKg + ", color=" + color + "]";
	}
	
}
