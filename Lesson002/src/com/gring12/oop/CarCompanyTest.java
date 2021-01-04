package com.gring12.oop;

public class CarCompanyTest {

	public static void main(String[] args) {
		CarCompany hyundai = CarCompany.getInstance();
		hyundai.showInfo();

		CarFactory cheongju = new CarFactory("청주");
		cheongju.produceCar(1000);
		cheongju.showInfo();
		hyundai.showInfo();

		CarCompany usahyundai = CarCompany.getInstance();
		CarFactory usa = new CarFactory("미국");
		usa.produceCar(500);
		usa.showInfo();
		usahyundai.showInfo();
	}

}
