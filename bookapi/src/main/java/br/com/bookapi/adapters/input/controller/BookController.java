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

import br.com.bookapi.adapters.input.mapper.BookMapper;
import br.com.bookapi.adapters.input.request.BookRequest;
import br.com.bookapi.adapters.input.response.BookResponse;
import br.com.bookapi.application.core.domain.Book;
import br.com.bookapi.application.ports.input.BookServicePort;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {

	private final BookServicePort bookServicePort;
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public void save(@RequestBody @Valid BookRequest bookRequest) {
		Book author = BookMapper.toBook(bookRequest);
		bookServicePort.save(author);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping
	public ResponseEntity<List<BookResponse>> getAll() {
		List<BookResponse> books = BookMapper.toResponse(bookServicePort.getAll());
		
		return ResponseEntity.ok(books);
	}
}
