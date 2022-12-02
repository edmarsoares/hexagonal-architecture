package br.com.bookapi.adapters.output.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bookapi.adapters.input.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long>{

	@Query("SELECT book FROM BookEntity book LEFT JOIN FETCH book.author")
	List<BookEntity> findAll();
}
