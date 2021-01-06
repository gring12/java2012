package com.gring12.realoop;

public class TestBeginner extends TestPlayerLevel {

	@Override
	public void run() {
		System.out.println("천천히 달립니다.");
	}

	@Override
	public void jump() {
		System.out.println("불가");
	}

	@Override
	public void turn() {
		System.out.println("불가");
	}

	@Override
	public void showLevelMessage() {
		System.out.println("*** 초보자 레벨입니다. ***");
		
	}
	

}
