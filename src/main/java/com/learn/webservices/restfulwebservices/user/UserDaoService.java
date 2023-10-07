package com.learn.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Steve", LocalDate.now().minusYears(52)));
        users.add(new User(3, "Mitchel", LocalDate.now().minusYears(12)));
        users.add(new User(4, "Dune", LocalDate.now().minusYears(92)));
    }

    public List<User> findAll() {
        return users;
    }

    public User saveUser(User user) {
        // Assign a new ID to the user
        user.setId(users.size() + 1);

        // Add the user to the end of the list
        users.add(user);

        return user;
    }

    public User findUser(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
