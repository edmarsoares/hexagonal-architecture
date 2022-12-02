package br.com.bookapi.adapters.input.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import br.com.bookapi.adapters.input.request.BookRequest;
import br.com.bookapi.adapters.input.response.AuthorResponse;
import br.com.bookapi.adapters.input.response.BookResponse;
import br.com.bookapi.application.core.domain.Author;
import br.com.bookapi.application.core.domain.Book;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookMapper {

	public static Book toBook(BookRequest bookRequest) {
		var book = new Book();
		var author = new Author();
		author.setId(bookRequest.getAuthorId());
		book.setAuthor(author);
		BeanUtils.copyProperties(bookRequest, book);
		
		return book;
	}
	
	public static List<BookResponse> toResponse(List<Book> books) {
		return books.stream().map(BookMapper::toResponse)
				.collect(Collectors.toList());
	}
	
	public static BookResponse toResponse(Book book) {
		var bookResponse = new BookResponse();
		var authorResponse = new AuthorResponse();
		
		BeanUtils.copyProperties(book.getAuthor(), authorResponse);
		BeanUtils.copyProperties(book, bookResponse);
		
		bookResponse.setAuthor(authorResponse);
		return bookResponse;
	}
}

