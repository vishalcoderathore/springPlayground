package com.learnspring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspring.demo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

    
} 