package com.learn.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserResource {

    private UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        super();
        this.userDaoService = userDaoService;
    }

    @GetMapping
    public List<User> listAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping(path = "/{id}")
    public User showUser(@PathVariable int id) {
        User user = userDaoService.findUser(id);

        if (user == null) {
            throw new UserNotFoundException("id:" + id);
        }

        return user;
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User savedUser = userDaoService.saveUser(user);

        // Create the location header for the newly created resource
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        // Send the location in the response header and return a 201 status code
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = userDaoService.deleteUser(id);

        if (user == null) {
            throw new UserNotFoundException("id:" + id);
        }
    }

}
