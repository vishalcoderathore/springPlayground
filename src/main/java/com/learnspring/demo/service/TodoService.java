package com.learnspring.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learnspring.demo.exception.TodoNotFoundException;
import com.learnspring.demo.model.Todo;
import com.learnspring.demo.repository.TodoRepository;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new TodoNotFoundException("Todo with id " + id + " not found");
        }
        todoRepository.deleteById(id);
    }

    public List<Todo> listTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodoById(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new TodoNotFoundException("Todo with id " + id + " not found");
        }
        return todoRepository.findById(id).get();
    }

    public Todo toggleCompletedStatus(Long id, Boolean completed){
        if (!todoRepository.existsById(id)) {
            throw new TodoNotFoundException("Todo with id " + id + " not found");
        }
        Todo todo = todoRepository.findById(id).get();
        todo.setCompleted(completed);
        return todoRepository.save(todo);
    }

}
