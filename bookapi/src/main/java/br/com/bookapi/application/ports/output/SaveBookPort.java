package br.com.bookapi.application.ports.output;

import br.com.bookapi.application.core.domain.Book;

public interface SaveBookPort {

	void save(Book author);
}
