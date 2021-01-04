package com.gring12.oop;

public class CarCompany {
	// STEP2. 인스턴스 생성
	private static CarCompany instance = new CarCompany();
	public static int carCompanyProducts = 0; // 총 생산대수

	// STEP1. private 생성자
	private CarCompany() {
	}

	// STEP3. public 매서드 생성
	public static CarCompany getInstance() {
		if (instance == null) {
			instance = new CarCompany();
		}
		return instance;
	}

	public void showInfo() {
		System.out.println("회사의 총 생산량은 " + carCompanyProducts + "입니다.");
	}

}// end of class
