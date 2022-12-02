package br.com.bookapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.bookapi.adapters.output.AuthorAdapter;
import br.com.bookapi.adapters.output.BookAdapter;
import br.com.bookapi.application.core.service.AuthorService;
import br.com.bookapi.application.core.service.BookService;

@Configuration
public class Config {

	@Bean
	public AuthorService authorService(AuthorAdapter authorAdapter) {
		return new AuthorService(authorAdapter, authorAdapter);
	}
	
	@Bean
	public BookService bookService(BookAdapter bookAdapter) {
		return new BookService(bookAdapter, bookAdapter);
	}
}
