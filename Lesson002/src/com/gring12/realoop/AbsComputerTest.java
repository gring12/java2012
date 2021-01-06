package com.gring12.realoop;

public class AbsComputerTest {

	public static void main(String[] args) {
		// AbsComputer c1 = new AbsComputer(); : AbsComputer는 추상 클래스이므로, new 예약어로 생성 X
		AbsComputer c2 = new AbsDesktop();
		// AbsComputer c3 = new AbsNotebook(); : AbsNotebook 역시 추상 클래스이므로 X
		AbsComputer c4 = new AbsMyNotebook();

		c2.display();
		c2.typing();
		
		c4.display(); //AbsNotebook 클래스를 상속받아 처리
		c4.typing();
	}// end of main

}// end of class
