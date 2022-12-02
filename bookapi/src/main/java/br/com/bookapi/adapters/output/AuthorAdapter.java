package br.com.bookapi.adapters.output;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.bookapi.adapters.input.mapper.AuthorEntityMapper;
import br.com.bookapi.adapters.output.repository.AuthorRepository;
import br.com.bookapi.application.core.domain.Author;
import br.com.bookapi.application.ports.output.LoadAuthorPort;
import br.com.bookapi.application.ports.output.SaveAuthorPort;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AuthorAdapter implements LoadAuthorPort, SaveAuthorPort{

	private final AuthorRepository authorRepository;
	
	@Override
	public void save(Author author) {
		var authorEntity = AuthorEntityMapper.mapper(author);
		authorRepository.save(authorEntity);
	}

	@Override
	public List<Author> getAll() {
		return AuthorEntityMapper.toAuthorList(authorRepository.findAll());	
	}
}
