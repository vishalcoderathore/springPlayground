package com.springboot.learnjpahibernate.book.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.learnjpahibernate.book.Books;

public interface BooksSpringDataJpaRepository  extends JpaRepository<Books, Long>{
    
}
