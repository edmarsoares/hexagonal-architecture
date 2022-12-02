package br.com.bookapi.application.ports.input;

import java.util.List;

import br.com.bookapi.application.core.domain.Author;

public interface AuthorServicePort {

	void save(Author author);
	
	List<Author> getAll();
}
