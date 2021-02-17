package com.example.ebook.repository;

import com.example.ebook.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ReviewRepository extends JpaRepository<Review, Integer>, QuerydslPredicateExecutor<Review> {
}
