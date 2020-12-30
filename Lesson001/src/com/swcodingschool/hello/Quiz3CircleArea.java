package com.swcodingschool.hello;

import java.util.Scanner;

public class Quiz3CircleArea {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("원의 반지름을 입력하세요. : ");
		int circle = sc.nextInt();
		
		double circleArea = circle * circle * 3.14;
		System.out.println(circleArea);
		
/*
 * final double PI = 3.141592;
 * Scanner sc = new Scanner(system.in);
 * System.out.printf("원의 반지름 (실수형) : ");
 * double radius = sc.nextDouble();
 * 
 * double circleArea = radius * radius * PI;
 * 
 * System.out.printf("반지름 %5.1f인 원의 넓이는 %10.2f", radius, circleArea)
 */
	}// end of main

}// end of class
