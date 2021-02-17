package com.example.ebook.service;

import com.example.ebook.dto.BookDTO;
import com.example.ebook.dto.PageDTO;
import com.example.ebook.dto.PagingDTO;
import com.example.ebook.entity.Book;



public interface BookService {
	
	Integer register(BookDTO dto);

	PagingDTO<BookDTO, Book> getList(PageDTO pageDTO);

	BookDTO read(int pno);

	void remove(int pno);

	void modify(BookDTO dto);

	default Book dtoToEntity(BookDTO dto) {
		Book entity = Book.builder().pno(dto.getPno()).name(dto.getName()).publisher(dto.getPublisher()).contents(dto.getContents()).pday(dto.getPday()).price(dto.getPrice()).build();
		return entity;
	}

	default BookDTO entityToDTO(Book entity){
		BookDTO dto = BookDTO.builder().pno(entity.getPno()).name(entity.getName()).publisher(entity.getPublisher()).contents(entity.getContents()).pday(entity.getPday()).price(entity.getPrice()).build();

		return dto;
	}


}
