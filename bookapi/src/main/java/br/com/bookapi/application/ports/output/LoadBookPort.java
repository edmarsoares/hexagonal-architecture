package br.com.bookapi.application.ports.output;

import java.util.List;

import br.com.bookapi.application.core.domain.Book;

public interface LoadBookPort {

	List<Book> getAll();
}
