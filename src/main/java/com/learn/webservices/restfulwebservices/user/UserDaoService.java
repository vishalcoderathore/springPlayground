package com.learn.webservices.restfulwebservices.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learn.webservices.restfulwebservices.jpa.UserRepository;

@Service
public class UserDaoService {

      private final UserRepository userRepository;

      public UserDaoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUser(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    // public User saveUser(User user) {
    //     // Assign a new ID to the user
    //     user.setId(users.size() + 1);

    //     // Add the user to the end of the list
    //     users.add(user);

    //     return user;
    // }

    // public User deleteUser(int id){
    //     User user = findUser(id);
    //     if(user != null){
    //         users.remove(user);
    //         return user;
    //     }
    //     return null;    
    // }
}
