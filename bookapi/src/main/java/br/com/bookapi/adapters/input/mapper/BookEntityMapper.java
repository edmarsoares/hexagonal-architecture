package br.com.bookapi.adapters.input.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import br.com.bookapi.adapters.input.entity.AuthorEntity;
import br.com.bookapi.adapters.input.entity.BookEntity;
import br.com.bookapi.application.core.domain.Author;
import br.com.bookapi.application.core.domain.Book;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookEntityMapper {

	public static BookEntity toBookEntity(Book book) {
		var bookEntity = new BookEntity();
		var author = new AuthorEntity();
		author.setId(book.getAuthor().getId());
		
		BeanUtils.copyProperties(book, bookEntity);
		
		bookEntity.setAuthor(author);
		return bookEntity;
	}
	
	public static Book toBook(BookEntity bookEntity) {
		var book = new Book();
		var author = new Author();
		BeanUtils.copyProperties(bookEntity, book);
		BeanUtils.copyProperties(bookEntity.getAuthor(), author);

		book.setAuthor(author);
		return book;
	}
	
	public static List<Book> toBookList(List<BookEntity> books) {
		return books.stream().map(BookEntityMapper::toBook)
				.collect(Collectors.toList());
	}
}

