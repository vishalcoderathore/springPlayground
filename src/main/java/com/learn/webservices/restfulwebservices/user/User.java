package com.learn.webservices.restfulwebservices.user;

import java.time.LocalDate;

public class User {

    public User(Integer id, String name, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    private Integer id;
    private String name;
    private LocalDate dob;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
    }

}
