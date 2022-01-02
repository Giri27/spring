package com.xworkz.newspaperApp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "newspaper_table")
public class NewspaperEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "newspaper_id")
	private int newspaperId;
	@Column(name = "newspaper_name")
	private String newspaperName;
	@Column(name = "newspaper_price")
	private double price;
	@Column(name = "newspaper_lang")
	private String language;
	@Column(name = "newspaper_pages")
	private int noOfPages;
	
	public NewspaperEntity(int newspaperId, String newspaperName, double price, String language, int noOfPages) {
		super();
		this.newspaperId = newspaperId;
		this.newspaperName = newspaperName;
		this.price = price;
		this.language = language;
		this.noOfPages = noOfPages;
	}
	public NewspaperEntity() {
		super();
	}
	public int getNewspaperId() {
		return newspaperId;
	}
	public void setNewspaperId(int newspaperId) {
		this.newspaperId = newspaperId;
	}
	public String getNewspaperName() {
		return newspaperName;
	}
	public void setNewspaperName(String newspaperName) {
		this.newspaperName = newspaperName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getNoOfPages() {
		return noOfPages;
	}
	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}
	@Override
	public String toString() {
		return "NewspaperEntity [newspaperId=" + newspaperId + ", newspaperName=" + newspaperName + ", price=" + price
				+ ", language=" + language + ", noOfPages=" + noOfPages + "]";
	}
}
