package com.learn.webservices.restfulwebservices.post;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.webservices.restfulwebservices.jpa.PostRepository;
import com.learn.webservices.restfulwebservices.jpa.UserRepository;
import com.learn.webservices.restfulwebservices.user.User;

@RestController
@RequestMapping("/users/{userId}/posts")
public class PostController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    // Create a post for a user
    @PostMapping
    public ResponseEntity<Object> createPost(@PathVariable Integer userId, @RequestBody Post post) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (!userOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        User user = userOptional.get();
        post.setUser(user);

        postRepository.save(post);

        return ResponseEntity.ok(post);
    }

    // Get all posts for a user
    @GetMapping
    public List<Post> getAllPostsByUser(@PathVariable Integer userId){
        return postRepository.findByUserId(userId);
    }
}
