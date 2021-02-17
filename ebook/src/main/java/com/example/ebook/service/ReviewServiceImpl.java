package com.example.ebook.service;

import com.example.ebook.dto.PageDTO;
import com.example.ebook.dto.PagingDTO;
import com.example.ebook.dto.ReviewDTO;
import com.example.ebook.entity.Review;
import com.example.ebook.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;

    @Override
    public Integer register(ReviewDTO dto) {
        log.info("DTO------------------------");
        log.info(dto);

        Review entity = dtoToEntity(dto);

        log.info(entity);

        repository.save(entity);

        return entity.getRno();

    }

    @Override
    public PagingDTO<ReviewDTO, Review> getList(PageDTO pageDTO){
        Pageable pageable = pageDTO.getPageable(Sort.by("rno").descending());

        Page<Review> result = repository.findAll(pageable);

        Function<Review, ReviewDTO> fn = (entity -> entityToDTO(entity));

        return new PagingDTO<>(result, fn);
    }

    @Override
    public ReviewDTO read(int rno){
        Optional<Review> result = repository.findById(rno);

        return result.isPresent()? entityToDTO(result.get()): null;
    }

    @Override
    public void remove(int rno){
        repository.deleteById(rno);
    }

    @Override
    public void modify(ReviewDTO dto) {
        Optional<Review> result = repository.findById(dto.getRno());

        if(result.isPresent()){
            Review entity = result.get();

            entity.changeName(dto.getRname());
            entity.changeContents(dto.getRcontents());

            repository.save(entity);
        }
    }
}
