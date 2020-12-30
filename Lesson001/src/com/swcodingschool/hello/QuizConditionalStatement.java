package com.swcodingschool.hello;

import java.util.Scanner;

public class QuizConditionalStatement {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("score를 입력하세요.");
		int score = sc.nextInt();

		if (score >= 90) {
			System.out.println(score + "는 A등급입니다.");
		} else if (score >= 80) {
			System.out.println(score + "는 B등급입니다.");
		} else if (score >= 70) {
			System.out.println(score + "는 C등급입니다.");
		} else {
			System.out.println("F등급입니다.");
		} // if end

		switch (score / 10) {
		case 10: case 9:
			System.out.println("당신의 등급은 A입니다.");
			break;
		case 8:
			System.out.println("당신의 등급은 B입니다.");
			break;
		case 7:
			System.out.println("당신의 등급은 C입니다.");
			break;
		default:
			System.out.println("당신의 등급은 F입니다.");
		}

	}// end of main

}// end of class
