package br.com.bookapi.adapters.input.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookRequest {

	@NotBlank(message = "Não pode ser nulo")
	private String title;

	@NotNull(message = "Não pode ser nulo")
	private LocalDate releaseDate;
	
	@NotNull(message = "Não pode ser nulo")
	private Long authorId;
}
