package com.example.ebook.controller;

import com.example.ebook.dto.PageDTO;
import com.example.ebook.dto.ReviewDTO;
import com.example.ebook.service.ReviewService;
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
@RequestMapping("/review")
@Log4j2
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;

    @GetMapping("/")
    public String index(){
        log.info("call index....");
        return "redirect:/review/rlist";
    }

    @GetMapping("/rlist")
    public void list(PageDTO pageDTO, Model model){
        log.info("list......." + pageDTO);

        model.addAttribute("result", service.getList(pageDTO));

    }

    @GetMapping("/rregister")
    public void register(){

        log.info("register get.....");
    }

    @PostMapping("/rregister")
    public String registerPost(ReviewDTO dto, RedirectAttributes redirectAttributes){
        log.info("dto..." + dto);

        Integer rno = service.register(dto);

        redirectAttributes.addFlashAttribute("msg", rno);

        return "redirect:/review/rlist";
    }

    @GetMapping({"/rread", "/rmodify"})
    public void read(int rno, @ModelAttribute("pageDTO") PageDTO pageDTO, Model model){
        log.info("rno : " + rno);

        ReviewDTO dto = service.read(rno);

        model.addAttribute("dto", dto);
    }

    @PostMapping("/rremove")
    public String remove(int rno, RedirectAttributes redirectAttributes){
        log.info("rno : " + rno);

        service.remove(rno);

        redirectAttributes.addFlashAttribute("msg", rno);

        return "redirect:/review/rlist";
    }

    @PostMapping("/rmodify")
    public String modify(ReviewDTO dto, @ModelAttribute("pageDTO") PageDTO pageDTO, RedirectAttributes redirectAttributes){
        log.info("post modify.....................");
        log.info("dto : " + dto);

        service.modify(dto);

        redirectAttributes.addAttribute("page", pageDTO.getPage());
        redirectAttributes.addAttribute("rno", dto.getRno());

        return "redirect:/review/rread";
    }
}
