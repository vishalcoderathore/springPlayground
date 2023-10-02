package com.springboot.learnjpahibernate.book.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.learnjpahibernate.book.Books;

public interface BooksSpringDataJpaRepository  extends JpaRepository<Books, Long>{

    List<Books> findByAuthor(String author);
    List<Books> findByName(String book);
    
}
