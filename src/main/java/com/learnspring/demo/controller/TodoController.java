package com.learnspring.demo.controller;

import com.learnspring.demo.model.Todo;
import com.learnspring.demo.service.TodoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> listTodos(){
        return todoService.listTodos();
    }

    @GetMapping("/{id}")
    public Todo viewTod(@PathVariable Long id){
        return todoService.getTodoById(id);
    }
    
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
}