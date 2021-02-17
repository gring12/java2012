package com.example.ebook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReviewDTO {
    private int rno;
    private String rname;
    private String rbook;
    private String rcontents;
}
