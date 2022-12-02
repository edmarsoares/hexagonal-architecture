package br.com.bookapi.application.ports.output;

import java.util.List;

import br.com.bookapi.application.core.domain.Author;

public interface LoadAuthorPort {

	List<Author> getAll();
}
