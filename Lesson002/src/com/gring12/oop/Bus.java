package com.gring12.oop;

public class Bus {
	int busNumber;
	int passengerCount;
	int money;
	
	public Bus(int busNumber) {
		this.busNumber = busNumber;
	}
	
	public void take(int money) {
		this.money += money;
		this.passengerCount++;
	}
	
	public void takeoff() {
		this.passengerCount--;
	}
	
	public void showInfo() {
		System.out.println(busNumber + "의 승객 수는 " + passengerCount + "이고, 수입은 " + money + "입니다.");
	}// end of showInfo()
}// end of class Bus
