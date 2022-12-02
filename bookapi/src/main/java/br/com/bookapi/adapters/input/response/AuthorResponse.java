package br.com.bookapi.adapters.input.response;

import lombok.Data;

@Data
public class AuthorResponse {

	private Long id;
	
	private String name;

	private String age;
	
	private String cpf;
}
