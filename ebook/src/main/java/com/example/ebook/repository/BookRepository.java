package com.example.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ebook.entity.Book;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BookRepository extends JpaRepository<Book, String>, QuerydslPredicateExecutor<Book> {

}
