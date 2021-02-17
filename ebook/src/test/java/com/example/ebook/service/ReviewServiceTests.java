package com.example.ebook.service;

import com.example.ebook.dto.ReviewDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReviewServiceTests {

    @Autowired
    private ReviewService service;

    @Test
    public void testRegister(){
        ReviewDTO reviewDTO = ReviewDTO.builder().rname("n****e").rbook("도시는 무엇으로 사는가").rcontents("건축에 대한 새로운 생각을 하게 되는 책입니다.").build();

        System.out.println(service.register(reviewDTO));
    }
}
