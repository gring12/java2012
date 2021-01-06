package com.gring12.realoop;
/*
 * 인터페이스 : 추상 메서드와 상수로만 구성
 * 				직접 인스턴스를 생성할 수 없다.
 */
public interface Calc {
	// Member Property : 상수로만 구성
	// 내부적으로 컴파일 과정에서 final 상수로 변환 처리됨
	double PI = 3.14;
	int ERROR = -999999;
	
	// Methods : Abstract Methods로만 구성
	// 내부적으로 컴파일 과정에서 Abstract Methods로 처리
	int add(int num1, int num2);
	int substract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);
	
	default void description() {
		System.out.println("정수 계산기를 구현합니다.");
	}
}
