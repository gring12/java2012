package com.gring12.realoop;

public class CalculatorTest {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 5;
		
		// 인터페이스, 추상클래스가 직접 객체를 생성할 수 없다.
		// Calc c = new Calc();
		// Calculator c = new Calculator();
		
		CompleteCalc c = new CompleteCalc();
		System.out.println(c.add(num1, num2));
		System.out.println(c.substract(num1, num2));
		System.out.println(c.times(num1, num2));
		System.out.println(c.divide(num1, num2));
		c.showInfo();
		c.description();
		
	}

}
