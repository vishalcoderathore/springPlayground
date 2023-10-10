package com.learn.webservices.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.webservices.restfulwebservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}