package com.xworkz.tvremote.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class TVRemote implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tvr_id")
	private int id;
	
	@Column(name = "rname")
	private String name;
	
	@Column(name = "rprice")
	private double price;
	
	@Column(name = "rcolor")
	private String color;
	
	@Column(name = "cell")
	private int noOfCells;
	
	@Column(name = "isworking")
	private boolean isPowerButtonWorking;

	public TVRemote() {
		System.out.println(this.getClass().getSimpleName() +" Bean created");
	}

	public TVRemote(String name, double price, String color, int noOfCells, boolean isPowerButtonWorking) {
		System.out.println(this.getClass().getSimpleName() +" Parameterized Bean created");
		this.name = name;
		this.price = price;
		this.color = color;
		this.noOfCells = noOfCells;
		this.isPowerButtonWorking = isPowerButtonWorking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNoOfCells() {
		return noOfCells;
	}

	public void setNoOfCells(int noOfCells) {
		this.noOfCells = noOfCells;
	}

	public boolean isPowerButtonWorking() {
		return isPowerButtonWorking;
	}

	public void setPowerButtonWorking(boolean isPowerButtonWorking) {
		this.isPowerButtonWorking = isPowerButtonWorking;
	}

	@Override
	public String toString() {
		return "TVRemote [name=" + name + ", price=" + price + ", color=" + color + ", noOfCells=" + noOfCells
				+ ", isPowerButtonWorking=" + isPowerButtonWorking + "]";
	}
}
