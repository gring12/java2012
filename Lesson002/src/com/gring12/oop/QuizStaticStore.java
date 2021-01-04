package com.gring12.oop;

public class QuizStaticStore {
	// 싱글톤패턴으로 정의하자...
	// 단계 1. private으로 생성자 선언
	// 단계 2. private static 으로 인스턴스 생성
	// 단계 3. public으로 인스턴에 접근할 수 있는 메서드
	public int guestCount;
	public int money;
	//단계 2
	private static QuizStaticStore instance = new QuizStaticStore();
	//단계 1
	private QuizStaticStore() {
		
	}
	// step 3.
	public static QuizStaticStore getInstance() {
		if(instance == null ) {
			instance = new QuizStaticStore();
		}
		return instance;
	}

	public void buy(int money) {
		this.money += money;
		this.guestCount++;
	}

	public void showInfo() {
		System.out.println("가게의 손님 수는 " + guestCount + "이고, 현재 수입은 " + money + "입니다.");
	}
}
