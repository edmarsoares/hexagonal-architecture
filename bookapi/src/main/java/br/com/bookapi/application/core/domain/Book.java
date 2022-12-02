package br.com.bookapi.application.core.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Book {

	private Long id;
	
	private String title;
	
	private LocalDate releaseDate;
	
	private Author author;
}
