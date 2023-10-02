package com.springboot.learnjpahibernate.book.jpa;

import org.springframework.stereotype.Repository;
import com.springboot.learnjpahibernate.book.Books;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class BooksJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Books book){
        entityManager.merge(book);
    }

    public Books findById(long id){
        return entityManager.find(Books.class, id);
    }

    public void delete(long id){
        Books book = findById(id);
        entityManager.remove(book);
    }
}
