package com.example.ebook.service;

import com.example.ebook.dto.BookDTO;
import com.example.ebook.entity.Book;



public interface BookService {
	
	Integer register(BookDTO dto);

	default Book dtoToEntity(BookDTO dto) {
		Book entity = Book.builder().pno(dto.getPno()).name(dto.getName()).publisher(dto.getPublisher()).pday(dto.getPday()).price(dto.getPrice()).build();
		return entity;
	}

}
