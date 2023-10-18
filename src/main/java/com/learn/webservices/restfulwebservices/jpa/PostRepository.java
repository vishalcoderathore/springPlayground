package com.learn.webservices.restfulwebservices.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.learn.webservices.restfulwebservices.post.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUserId(Integer userId);
}
