package br.com.bookapi.adapters.input.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import br.com.bookapi.adapters.input.entity.AuthorEntity;
import br.com.bookapi.application.core.domain.Author;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorEntityMapper {

	public static AuthorEntity mapper(Author author) {
		var authorEntity = new AuthorEntity();
		BeanUtils.copyProperties(author, authorEntity);
		
		return authorEntity;
	}
	
	public static Author toAuthor(AuthorEntity authorEntity) {
		var author = new Author();
		BeanUtils.copyProperties(authorEntity, author);
		
		return author;
	}
	
	public static List<Author> toAuthorList(List<AuthorEntity> authors) {
		return authors.stream().map(AuthorEntityMapper::toAuthor)
				.collect(Collectors.toList());
	}
}

