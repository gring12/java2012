package com.gring12.oop;
/*
 * 매장이 하나 있고, 매장과 거래하는 손님들이 있다.
 * 매장은 싱글톤패턴으로 구현하고, 다수의 손님들이 물건을 구매한다.
 * 이를 객체 지향 프로그램으로 시뮬레이션 해보자.
 * 손님 : 손님ID, 돈
 * 매장 : 손님카운트, 돈
 */
public class QuizStatic {
	
	public static void main(String[] args) {
		QuizStaticStore store1 = QuizStaticStore.getInstance();
		QuizStaticStore store2 = QuizStaticStore.getInstance();
		System.out.println(store1);
		System.out.println(store2);
		QuizStaticGuest guest123 = new QuizStaticGuest(123, 10000);
		QuizStaticGuest guest456 = new QuizStaticGuest(456, 20000);
		
		//구입 전
		guest123.showInfo();
		guest456.showInfo();
		
		//구입
		guest123.buy(store1, 1000);
		guest456.buy(store2, 2000);
		
		//구입 후
		guest123.showInfo();
		guest456.showInfo();
	}
}
