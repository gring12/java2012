package com.example.ebook.service;

import com.example.ebook.dto.PageDTO;
import com.example.ebook.dto.PagingDTO;
import com.example.ebook.dto.ReviewDTO;
import com.example.ebook.entity.Review;

public interface ReviewService {

    Integer register(ReviewDTO dto);

    PagingDTO<ReviewDTO, Review> getList(PageDTO pageDTO);

    ReviewDTO read(int rno);

    void remove(int rno);

    void modify(ReviewDTO dto);

    default Review dtoToEntity(ReviewDTO dto) {
        Review entity = Review.builder().rno(dto.getRno()).rname(dto.getRname()).rbook(dto.getRbook()).rcontents(dto.getRcontents()).build();
        return entity;
    }

    default ReviewDTO entityToDTO(Review entity){
        ReviewDTO dto = ReviewDTO.builder().rno(entity.getRno()).rname(entity.getRname()).rbook(entity.getRbook()).rcontents(entity.getRcontents()).build();

        return dto;
    }
}
