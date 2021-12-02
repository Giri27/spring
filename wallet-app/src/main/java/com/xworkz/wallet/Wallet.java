package com.xworkz.wallet;

public class Wallet {
	
	private String color;
	private String brand;
	private double price;
	private Material material;
	private Money money;
	private ATMCard atmCard;
	private Photo photo;
	
	public Wallet() {
		System.out.println(this.getClass().getSimpleName() +" Bean Created");
	}

	public Wallet(String color, String brand, double price, Material material, Money money, ATMCard atmCard,
			Photo photo) {
		this.color = color;
		this.brand = brand;
		this.price = price;
		this.material = material;
		this.money = money;
		this.atmCard = atmCard;
		this.photo = photo;
		System.out.println("Parameterized "+ this.getClass().getSimpleName() +" Bean Created");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}

	public ATMCard getAtmCard() {
		return atmCard;
	}

	public void setAtmCard(ATMCard atmCard) {
		this.atmCard = atmCard;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	
	
	
	

}
