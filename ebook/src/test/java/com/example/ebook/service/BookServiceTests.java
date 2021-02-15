package com.example.ebook.service;

import com.example.ebook.dto.BookDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTests {

    @Autowired
    private BookService service;

    @Test
    public void testRegister(){
        BookDTO bookDTO = BookDTO.builder().name("당신의 별자리는 무엇인가요").publisher("와이즈베리").pday(20190226).price(15800).build();

        System.out.println(service.register(bookDTO));
    }
}
