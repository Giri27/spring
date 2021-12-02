package com.xworkz.wallet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WalletTester {
	
	public static void main(String[] args) {
		
		String springConfigFile = "wallet.xml";
		ApplicationContext springContainer = new ClassPathXmlApplicationContext(springConfigFile);
		System.out.println("SpringContainer is created "+springContainer);
		
		Wallet wallet = springContainer.getBean(Wallet.class);
		Object walletObject = springContainer.getBean("walletId");
		System.out.println("Wallet object "+walletObject);
		Wallet w = (Wallet) walletObject;
		System.out.println("wallet object "+w);
		
		Photo photo = springContainer.getBean(Photo.class);
		System.out.println(photo);
		
		Connection con = springContainer.getBean(Connection.class);
		System.out.println(con);
	}

}
