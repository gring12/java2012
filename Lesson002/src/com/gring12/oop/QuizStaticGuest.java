package com.gring12.oop;

public class QuizStaticGuest {
	public int guestID;
	public int money;
	
	public QuizStaticGuest(int guestID, int money) {
		this.guestID = guestID;
		this.money = money;
	}
	
	public void buy(QuizStaticStore store) {
		store.buy(1000);
		this.money -= 1000;
	}
	
	public void showInfo( ) {
		System.out.println(guestID + "의 현재 잔액은 " + money + "입니다.");
	}
	
}
