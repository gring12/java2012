package com.gring12.oop;
/*
 * 1. 클래스 객체 (instance로)를 만드는 방법을 설명한다.
 * 2. 접근제어자 (access modifier) 의 개념을 확인한다.
 * 					class		package		subclass	global
 * 		public		  o			   o			o		   o
 * 		protected	  o			   o			o		   x
 * 		default		  o			   o			x		   x		/ 접근가능 o
 * 		private		  o			   x			x		   x		/ 접근불가 x
 *   - 정보은닉 (information hiding) = 보안관리
 * 3. 생성자 (constructor)의 개념을 확인한다.
 * 	 - 오버로딩
 */
public class StudentTest {

	public static void main(String[] args) {
		// Student 클래스의 객체 생성하기
		// 생성자는 클래스의 이름과 동일한 메서드.
		// 특히 패러미터가 없는 생성자=디폴트 생성자
		// 기본 생성자를 통해 객체가 생성되었을 때
		// 메모리 공간 안에서는 무슨 일이 생길까?
		Student stYounju = new Student();
		Student stDain = new Student(2, "이다인", 2, "청주시");
		
		System.out.println(stYounju);
		System.out.println(stDain);
		
		
//		stYounju.studentName = "정윤주";
//		stYounju.grade = 1;
//		stDain.studentName = "이다인";
//		stDain.grade = 2;
		
		stYounju.setStudentID(1);
		stYounju.setStudentName("정윤주");
//		System.out.println(stYounju.getStudentID());
//		System.out.println(stYounju.getStudentName());
		
		stYounju.showInfo();
		stDain.showInfo();
		
//		stYounju.study();
//		stDain.study();
	}// end of main

}// end of class
