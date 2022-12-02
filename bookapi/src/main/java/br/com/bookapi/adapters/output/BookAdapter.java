package br.com.bookapi.adapters.output;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.bookapi.adapters.input.entity.BookEntity;
import br.com.bookapi.adapters.input.mapper.BookEntityMapper;
import br.com.bookapi.adapters.output.repository.BookRepository;
import br.com.bookapi.application.core.domain.Book;
import br.com.bookapi.application.ports.output.LoadBookPort;
import br.com.bookapi.application.ports.output.SaveBookPort;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BookAdapter implements LoadBookPort, SaveBookPort{

	private final BookRepository bookRepository;
	
	@Override
	public void save(Book book) {
		var bookEntity = BookEntityMapper.toBookEntity(book);
		bookRepository.save(bookEntity);
	}

	@Override
	public List<Book> getAll() {
		List<BookEntity> findAll = bookRepository.findAll();
		
		return BookEntityMapper.toBookList(findAll);	
	}
}
