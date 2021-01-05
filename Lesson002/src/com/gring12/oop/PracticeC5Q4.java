package com.gring12.oop;

public class PracticeC5Q4 {

	private int day;
	private int month;
	private int year;
	private boolean isValid = true;
	
	public PracticeC5Q4(int day, int month, int year) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		if(month == 2) {
			if(day <1 || day > 28) {
				System.out.println("오류입니다.");
			} else {
			this.day = day;
			}
		}
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}	
	
		
}// end of class
