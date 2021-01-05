package com.gring12.array;

import java.util.Scanner;

/*
 * 2차원 배열의 예제
 * 학생 3명의 국,영,수 과목의 총점과 평균을 구하여 출력하는 프로그램을 구성하시오.
 * 접근 순서 (Pseudo Code => Algorithm)
 * 1. 배열 double [3][5] score 선언  
 * 2. 학생 성적은 어떤 방법? 사용자로부터 입력받는다.
 * 		for loop 행 {
 * 			for loop 열 {
 * 			 	학생의 국/영/수 성적을 입력받는다.
 * 	        }
 * 		}
 * 3. 	for loop 행 {
 * 			for loop 열 {
 * 			 개인별 총점과 평균을 계산한다.
 * 	   			총점 = score[i][3]
 * 	        }
 * 		  평균  = 총점 / 3
 * 		}
 *  4. 다중 for loop을 이용, 배열 전체를 출력한다.
 */
public class Scoring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[][] score = new double[3][5]; // 배열 선언
		
		// 2. 성적을 입력받는다. 
		//    이때 행은 학생별, 열은 국,영,수 과목별점수
		//    반복 횟수 제어를 위해 각 행 열의길이 - 2를 사용
		//    (총점,평균 제외)
		for(int row=0;row < score.length;row++) {
			System.out.println((row+1) + "번 째 학생의 성적을 입력해주세요.");
			for(int col=0;col < score[row].length - 2; col++) {
				System.out.printf("%d과목 : %n", col+1);
				score[row][col] = sc.nextDouble();
			}
			System.out.println();
		}
		
		// 3. 개인별 총점과 평균을 계산한다.
		for(int row=0;row < score.length; row++) {
			for(int col=0;col < score[row].length - 2;col++) {
				score[row][3] += score[row][col];
			}
			score[row][4] = score[row][3] / 3.0;
		}
		
		// 4. 배열 전체를 출력한다.
		System.out.printf("과목1\t과목2\t과목3\t총점\t평균\n");
		for(int row=0;row < score.length;row++) {
			for(int col=0;col < score[row].length;col++) {
				System.out.printf("%5.1f\t",score[row][col]);
			}
			System.out.println();
		}
		
	}// end of main

}// end of class
