package com.example.ebook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pno;

	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 100, nullable = false)
	private String publisher;

	@Column(nullable = false)
	private int pday;

	@Column(nullable = false)
	private int price;

	
}
