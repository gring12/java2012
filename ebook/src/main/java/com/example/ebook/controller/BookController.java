package com.example.ebook.controller;

import com.example.ebook.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
@Log4j2
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping("/list")
    public String index(){

        return "/book/list";
    }
}
