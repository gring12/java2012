package com.gring12.oop;

public class CarFactory {
	private String factoryName; // 공장 이름
	private int productCounts; // 공장의 생산대수

	CarFactory(String factoryName) {
		this.factoryName = factoryName;
	}

	public void produceCar(int produceNumber) {
		productCounts += produceNumber;
		CarCompany.carCompanyProducts += produceNumber;
	}

	public void showInfo() {
		System.out.println(factoryName + "공장의 현재까지 생산량은 " + productCounts + "입니다.");
	}
}// end of class
