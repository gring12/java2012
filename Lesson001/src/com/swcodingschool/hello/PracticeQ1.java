package com.swcodingschool.hello;

// 구구단 (짝수 단만 출력)
public class PracticeQ1 {

	public static void main(String[] args) {
		int dan;
		int times;
		
		for(dan = 2; dan <= 9 ; dan++) {
			if(dan % 2 == 1)
				continue;
			for(times = 1; times <= 9 ; times++) {
				System.out.println(dan + "X" + times + "=" + dan * times);
			}
			System.out.println( );
		}// for end
	}// end of main

}// end of class
