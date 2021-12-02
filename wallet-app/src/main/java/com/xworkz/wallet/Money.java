package com.xworkz.wallet;

public class Money {
	
	private double size;
	private String type;
	private boolean isCoinOrNote;
	private String color;
	
	public Money() {
		System.out.println(this.getClass().getSimpleName() +" Bean Created");
	}

}
