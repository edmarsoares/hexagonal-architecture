package br.com.bookapi.adapters.input.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import br.com.bookapi.adapters.input.request.AuthorRequest;
import br.com.bookapi.adapters.input.response.AuthorResponse;
import br.com.bookapi.application.core.domain.Author;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorMapper {

	public static Author toAuthor(AuthorRequest authorRequest) {
		var author = new Author();
		BeanUtils.copyProperties(authorRequest, author);
		
		return author;
	}
	
	public static List<AuthorResponse> toResponse(List<Author> authors) {
		return authors.stream().map(AuthorMapper::toResponse)
				.collect(Collectors.toList());
	}
	
	public static AuthorResponse toResponse(Author author) {
		var authorResponse = new AuthorResponse();
		BeanUtils.copyProperties(author, authorResponse);
		
		return authorResponse;
	}
}

