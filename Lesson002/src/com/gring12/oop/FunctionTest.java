package com.gring12.oop;
/*
 * 함수의 정의와 호출을 디버깅을 통해 확인
 * 변수의 영향 범위 (scope)
 * scope 내에서 디버깅 확인 : F6 / scope 외부 : F5
 * local variable 지역변수
 * global variable 전역변수  ~= class variable (클래스 내 메서드와 관계없이 영향을 주는 변수)
 * class 변수 선언 시 static 키워드 사용 
 */
public class FunctionTest {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		
		int sum = add(num1, num2);
		System.out.println(num1 + " + " + num2 + " = " + sum + "입니다.");
	}// end of main
	
	public static int add(int n1, int n2) {
		return n1 + n2;
	}

}// end of class
