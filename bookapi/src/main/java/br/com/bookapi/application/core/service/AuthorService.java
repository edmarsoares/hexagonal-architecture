package br.com.bookapi.application.core.service;

import java.util.List;

import br.com.bookapi.application.core.domain.Author;
import br.com.bookapi.application.ports.input.AuthorServicePort;
import br.com.bookapi.application.ports.output.LoadAuthorPort;
import br.com.bookapi.application.ports.output.SaveAuthorPort;

public class AuthorService implements AuthorServicePort{

	private SaveAuthorPort saveAuthorPort;
	private LoadAuthorPort loadAuthorPort;
	
	public AuthorService(SaveAuthorPort saveAuthorPort, LoadAuthorPort loadAuthorPort) {
		this.saveAuthorPort = saveAuthorPort;
		this.loadAuthorPort = loadAuthorPort;
	}
	
	@Override
	public void save(Author author) {
		saveAuthorPort.save(author);
	}

	@Override
	public List<Author> getAll() {
		return loadAuthorPort.getAll();
	}
}
