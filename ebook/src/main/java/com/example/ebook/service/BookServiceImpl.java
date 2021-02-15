package com.example.ebook.service;

import com.example.ebook.entity.Book;
import com.example.ebook.dto.BookDTO;
import com.example.ebook.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private final BookRepository repository;

	@Override
	public Integer register(BookDTO dto) {
		log.info("DTO------------------------");
		log.info(dto);

		Book entity = dtoToEntity(dto);

		log.info(entity);

		repository.save(entity);

		return entity.getPno();

	}



}
