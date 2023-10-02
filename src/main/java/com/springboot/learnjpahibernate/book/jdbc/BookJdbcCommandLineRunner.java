package com.springboot.learnjpahibernate.book.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.learnjpahibernate.book.Books;

@Component
public class BookJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private BookJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Books((long) 1, "Chemistry", "Shannon"));
        repository.insert(new Books((long) 2, "Learn AWS", "Bosco"));
        repository.insert(new Books((long) 3, "Coffee", "Pete"));
        repository.insert(new Books((long) 4, "Food", "Pizza"));

        // Chemistry and Food should be deleted
        repository.delete((long) 1);
        repository.delete((long) 4);

        // Fetch Book by id
        System.out.println(repository.findById((long) 3));
    }
}
