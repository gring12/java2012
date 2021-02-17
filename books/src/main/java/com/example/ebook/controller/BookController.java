package com.example.ebook.controller;

import com.example.ebook.dto.BookDTO;
import com.example.ebook.dto.PageDTO;
import com.example.ebook.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/books")
@Log4j2
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping("/")
    public String index(){

        return "redirect:/books/list";
    }

    @GetMapping("/list")
    public void list(PageDTO pageDTO, Model model){
        log.info("list......." + pageDTO);

        model.addAttribute("result", service.getList(pageDTO));

    }

    @GetMapping("/register")
    public void register(){

        log.info("register get.....");
    }

    @PostMapping("/register")
    public String registerPost(BookDTO dto, RedirectAttributes redirectAttributes){
        log.info("dto..." + dto);

        Integer pno = service.register(dto);

        redirectAttributes.addFlashAttribute("msg", pno);

        return "redirect:/books/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(int pno, @ModelAttribute("pageDTO") PageDTO pageDTO, Model model){
        log.info("pno : " + pno);

        BookDTO dto = service.read(pno);

        model.addAttribute("dto", dto);
    }

    @PostMapping("/remove")
    public String remove(int pno, RedirectAttributes redirectAttributes){
        log.info("pno : " + pno);

        service.remove(pno);

        redirectAttributes.addFlashAttribute("msg", pno);

        return "redirect:/books/list";
    }

    @PostMapping
    public String modify(BookDTO dto, @ModelAttribute("pageDTO") PageDTO pageDTO, RedirectAttributes redirectAttributes){
        log.info("post modify.....................");
        log.info("dto : " + dto);

        service.modify(dto);

        redirectAttributes.addAttribute("page", pageDTO.getPage());
        redirectAttributes.addAttribute("pno", dto.getPno());

        return "redirect:/books/read";
    }
}
