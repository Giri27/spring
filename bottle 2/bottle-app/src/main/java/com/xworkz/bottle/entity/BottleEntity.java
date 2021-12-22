package com.xworkz.bottle.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bottle")
public class BottleEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idbottle")
	private int bid;
	@Column(name = "bottlebrand")
	private String bbrand;
	@Column(name = "bottletype")
	private String btype;
	@Column(name = "bottleprice")
	private double price;
	
	public BottleEntity() {
		System.out.println(this.getClass().getSimpleName()+ " Bean created");
	}
	public BottleEntity(int bid, String bbrand, String btype, double price) {
		System.out.println(this.getClass().getSimpleName()+ " Parameterized Bean created");
		this.bid = bid;
		this.bbrand = bbrand;
		this.btype = btype;
		this.price = price;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBbrand() {
		return bbrand;
	}
	public void setBbrand(String bbrand) {
		this.bbrand = bbrand;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BottleEntity [bid=" + bid + ", bbrand=" + bbrand + ", btype=" + btype + ", price=" + price + "]";
	}
}
