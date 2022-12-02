package br.com.bookapi.application.core.domain;

import lombok.Data;

@Data
public class Author {

	private Long id;

	private String name;

	private String age;
	
	private String cpf;
}
