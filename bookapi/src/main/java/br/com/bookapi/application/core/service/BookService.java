package br.com.bookapi.application.core.service;

import java.util.List;

import br.com.bookapi.application.core.domain.Book;
import br.com.bookapi.application.ports.input.BookServicePort;
import br.com.bookapi.application.ports.output.LoadBookPort;
import br.com.bookapi.application.ports.output.SaveBookPort;

public class BookService implements BookServicePort{

	private SaveBookPort saveBookPort;
	private LoadBookPort loadBookPort;
	
	public BookService(SaveBookPort saveBookPort, LoadBookPort loadBookPort) {
		this.saveBookPort = saveBookPort;
		this.loadBookPort = loadBookPort;
	}
	
	@Override
	public void save(Book author) {
		saveBookPort.save(author);
	}

	@Override
	public List<Book> getAll() {
		return loadBookPort.getAll();
	}
}
