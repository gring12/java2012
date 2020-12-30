package com.swcodingschool.hello;

import java.util.Scanner;

public class QuizConditionalStatement {

	public static void main(String[] args) {
		int score = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("score를 입력하세요.");
		int scoreOfStudent = sc.nextInt();
				
		if(score>=90) {
			System.out.println(score + "는 A등급입니다.");
		}
		else if(score>=80) {
			System.out.println(score + "는 B등급입니다.");
		}
		else if(score>=70) {
			System.out.println(score + "는 C등급입니다.");
		}
		else {
			System.out.println("F등급입니다.");
		}// end of else
		
		
			
		}// end of main
		
	
	}// end of class

