package com.learnboot.mywebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "vishal", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2, "vishal", "Practice Java", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(3, "vishal", "Learn French", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }
}
