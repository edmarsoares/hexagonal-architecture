package br.com.bookapi.application.ports.input;

import java.util.List;

import br.com.bookapi.application.core.domain.Book;

public interface BookServicePort {

	void save(Book author);
	
	List<Book> getAll();
}
