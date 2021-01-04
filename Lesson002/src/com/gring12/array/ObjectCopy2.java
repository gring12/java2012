package com.gring12.array;
/*
 * 얕은 복사 : 인스턴스의 주소값만 복사하므로, 원본-사본의 인스턴스값이 모두 변경됨.
 */
public class ObjectCopy2 {

	public static void main(String[] args) {
		Book[] bookArray1 = new Book[3];
		Book[] bookArray2 = new Book[3];
		
		bookArray1[0] = new Book("태백산맥","조정래");
		bookArray1[1] = new Book("데미안","헤르만 헤세");
		bookArray1[2] = new Book("어떻게 살 것인가","유시민");
		System.arraycopy(bookArray1, 0, bookArray2, 0, 3);
		
		for(int i = 0; i < bookArray2.length; i++) {
			bookArray2[i].showBookInfo();
		}
		
		bookArray1[0].setBookName("나목");
		bookArray1[0].setAuthor("박완서"); //bookArray1의 서명, 저자 변경
		
		System.out.println("=== bookArray1 ===");
		for(int i = 0; i < bookArray1.length; i++) {
			bookArray1[i].showBookInfo();
		}// bookArray1의 변경 여부 확인

		System.out.println("=== bookArray2 ===");
		for(int i = 0; i < bookArray2.length; i++) {
			bookArray2[i].showBookInfo();
		}// bookArray2의 변경 여부 확인
		
		
	}// end of main

}// end of class
