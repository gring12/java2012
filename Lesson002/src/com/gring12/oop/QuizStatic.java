package com.gring12.oop;
/*
 * 매장이 하나 있고, 매장과 거래하는 손님들이 있다.
 * 매장은 싱글톤패턴으로 구현하고, 다수의 손님들이 물건을 구매한다.
 * 이를 객체 지향 프로그램으로 시뮬레이션 해보자.
 * 손님 : 손님ID, 돈
 * 매장 : 손님카운트, 돈
 */
public class QuizStatic {
		
	QuizStaticGuest guest123 = new QuizStaticGuest(123, 10000);
	QuizStaticGuest guest456 = new QuizStaticGuest(456, 20000);
}
