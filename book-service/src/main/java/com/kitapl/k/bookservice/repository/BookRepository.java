package com.kitapl.k.bookservice.repository;

import com.kitapl.k.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;
@EnableJpaRepositories
public interface BookRepository extends JpaRepository<Book,String> {

    Optional<Book> findBooksByIsbn(String isbn);
}
