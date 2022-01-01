package com.xworkz.newspaperApp.dto;

import org.springframework.stereotype.Component;

@Component
public class NewspaperDTO {
	
	String newspaperName;
	double price;
	String language;
	int noOfPages;
	
	public NewspaperDTO(String newspaperName, double price, String language, int noOfPages) {
		this.newspaperName = newspaperName;
		this.price = price;
		this.language = language;
		this.noOfPages = noOfPages;
	}
	public NewspaperDTO() {
		super();
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
		return "Newspaper [newspaperName=" + newspaperName + ", price=" + price + ", language=" + language
				+ ", noOfPages=" + noOfPages + "]";
	}
	
}
