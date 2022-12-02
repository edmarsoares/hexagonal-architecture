package br.com.bookapi.adapters.input.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BookResponse {

	private Long id;
	
	private String title;
	
	private LocalDate releaseDate;
	
	private AuthorResponse author;
}
