package br.com.bookapi.application.ports.output;

import br.com.bookapi.application.core.domain.Author;

public interface SaveAuthorPort {

	void save(Author author);
}
