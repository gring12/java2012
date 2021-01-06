package com.gring12.realoop;

public class TestSuper extends TestPlayerLevel {

	@Override
	public void run() {
		System.out.println("매우 빠르게 달립니다.");
	}

	@Override
	public void jump() {
		System.out.println("매우 높이 점프합니다.");
	}

	@Override
	public void turn() {
		System.out.println("한 바퀴 돕니다.");
	}

	@Override
	public void showLevelMessage() {
		System.out.println("*** 고급자 레벨입니다. ***");
	}

}
