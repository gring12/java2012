package com.gring12.realoop;

public class TestAdvanced extends TestPlayerLevel {

	@Override
	public void run() {
		System.out.println("빠르게 달립니다.");
	}

	@Override
	public void jump() {
		System.out.println("높이 점프합니다.");
	}

	@Override
	public void turn() {
		System.out.println("불가");
	}

	@Override
	public void showLevelMessage() {
		System.out.println("*** 중급자 레벨입니다. ***");
	}

}
