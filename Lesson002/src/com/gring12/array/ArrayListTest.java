package com.gring12.array;

import java.util.ArrayList;

/* 
 * ArrayList<> 선언 및 활용 방법
 */
public class ArrayListTest {

	public static void main(String[] args) {
		// ArrayList<> 선언 후, import
		ArrayList<Book> library = new ArrayList<Book>();
		
		library.add(new Book("태백산맥", "조정래"));
		library.add(new Book("데미안", "헤르만 헤세"));
		library.add(new Book("어떻게 살 것인가", "유시민"));
		library.add(new Book("토지", "박경리"));
		library.add(new Book("어린 왕자", "생텍쥐페리"));
		
		for(int i = 0; i < library.size(); i++) {
			Book book = library.get(i);
			book.showBookInfo();
		}
		
		System.out.println("===================");
		for(Book book: library) {
			book.showBookInfo();
		}
	}

}
