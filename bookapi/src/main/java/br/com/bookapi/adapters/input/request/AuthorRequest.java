package br.com.bookapi.adapters.input.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthorRequest {

	@NotBlank(message = "Não pode ser nulo ou vazio")
	private String name;

	@NotBlank(message = "Não pode ser nulo ou vazio")
	private String age;
	
	@NotBlank(message = "Não pode ser nulo ou vazio")
	private String cpf;
}
