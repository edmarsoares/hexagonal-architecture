package br.com.bookapi.adapters.input.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bookapi.adapters.input.mapper.AuthorMapper;
import br.com.bookapi.adapters.input.request.AuthorRequest;
import br.com.bookapi.adapters.input.response.AuthorResponse;
import br.com.bookapi.application.core.domain.Author;
import br.com.bookapi.application.ports.input.AuthorServicePort;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/author")
@AllArgsConstructor
public class AuthorController {

	private final AuthorServicePort authorServicePort;
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public void save(@RequestBody @Valid AuthorRequest authorRequest) {
		Author author = AuthorMapper.toAuthor(authorRequest);
		authorServicePort.save(author);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping
	public ResponseEntity<List<AuthorResponse>> getAll() {
		List<AuthorResponse> authors = AuthorMapper.toResponse(authorServicePort.getAll());
		
		return ResponseEntity.ok(authors);
	}
}
