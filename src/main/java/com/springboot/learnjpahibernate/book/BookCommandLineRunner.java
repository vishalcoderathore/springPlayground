package com.springboot.learnjpahibernate.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.springboot.learnjpahibernate.book.springdatajpa.BooksSpringDataJpaRepository;

@Component
public class BookCommandLineRunner implements CommandLineRunner {

    // Using JDBC 
    // @Autowired
    // private BookJdbcRepository repository;

    // Using JPA
    // @Autowired
    // private BooksJpaRepository repository;

    // Using Spring JPA
    @Autowired
    private BooksSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Books((long) 1, "Chemistry_with_JPA", "Shannon"));
        repository.save(new Books((long) 2, "Learn AWS_with_JPA", "Bosco"));
        repository.save(new Books((long) 3, "Coffee_with_JPA", "Pete"));
        repository.save(new Books((long) 4, "Food_with_JPA", "Pizza"));

        // Chemistry and Food should be deleted
        repository.deleteById(1l);
        repository.deleteById(4l);

        // Fetch Book by id
        System.out.println(repository.findById((long) 3));
    }
}
