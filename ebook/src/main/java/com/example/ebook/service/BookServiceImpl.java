package com.example.ebook.service;

import com.example.ebook.dto.PageDTO;
import com.example.ebook.dto.PagingDTO;
import com.example.ebook.entity.Book;
import com.example.ebook.dto.BookDTO;
import com.example.ebook.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

import java.util.Optional;
import java.util.function.Function;

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

	@Override
	public PagingDTO<BookDTO, Book> getList(PageDTO pageDTO){
		Pageable pageable = pageDTO.getPageable(Sort.by("pno").descending());

		Page<Book> result = repository.findAll(pageable);

		Function<Book, BookDTO> fn = (entity -> entityToDTO(entity));

		return new PagingDTO<>(result, fn);
	}

	@Override
	public BookDTO read(int pno){
		Optional<Book> result = repository.findById(pno);

		return result.isPresent()? entityToDTO(result.get()): null;
	}

	@Override
	public void remove(int pno){
		repository.deleteById(pno);
	}

	@Override
	public void modify(BookDTO dto) {
		Optional<Book> result = repository.findById(dto.getPno());

		if(result.isPresent()){
			Book entity = result.get();

			entity.changeName(dto.getName());
			entity.changeContents(dto.getContents());
			entity.changePublisher(dto.getPublisher());
			entity.changePday(dto.getPday());
			entity.changePrice(dto.getPrice());

			repository.save(entity);
		}
	}



}
