package com.example.ebook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDTO {

	private int pno;
	private String name;
	private String publisher;
	private int pday;
	private int price;
	
}
