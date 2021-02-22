package com.example.ebook.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rno;

    @Column(length = 100, nullable = false)
    private String rname;

    @Column(length = 100, nullable = false)
    private String rbook;

    @Column(length = 200, nullable = false)
    private String rcontents;

    public void changeName(String rname){
        this.rname = rname;
    }

    public void changeContents(String rcontents){
        this.rcontents = rcontents;
    }

    public void changeBook(String rbook) { this.rbook = rbook; }
}
