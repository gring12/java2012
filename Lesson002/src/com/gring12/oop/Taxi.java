package com.gring12.oop;

public class Taxi {
	String companyName;
	int money;
	
	public Taxi(String companyName) {
		this.companyName = companyName;
	}
	
	public void take(int money) {
		this.money += money;
	}
	
	public void showInfo() {
		System.out.println(companyName + " 택시 회사의 수입은 " + money + "입니다.");
	}
}
