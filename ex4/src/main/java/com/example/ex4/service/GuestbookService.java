package com.example.ex4.service;

import com.example.ex4.dto.GuestbookDTO;
import com.example.ex4.dto.PageRequestDTO;
import com.example.ex4.dto.PageResultDTO;
import com.example.ex4.entity.Guestbook;

public interface GuestbookService {
    Long register(GuestbookDTO dto);

    PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO);

    GuestbookDTO read(Long gno);

    void remove(Long gno);

    void modify(GuestbookDTO dto);

    default Guestbook dtoToEntity(GuestbookDTO dto){
        Guestbook entity = Guestbook.builder().gno(dto.getGno()).title(dto.getTitle()).content(dto.getContent()).writer(dto.getWriter()).build();
        return entity;
    }

    default GuestbookDTO entityToDTO(Guestbook entity){
        GuestbookDTO dto = GuestbookDTO.builder().gno(entity.getGno()).title(entity.getTitle()).content(entity.getContent()).writer(entity.getWriter()).regDate(entity.getRegDate()).modDate(entity.getModDate()).build();

        return dto;
    }


}
