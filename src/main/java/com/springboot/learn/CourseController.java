package com.springboot.learn;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Retrun course id, name, author

@RestController
public class CourseController {
    
    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses(){
        return Arrays.asList(
            new Course(1, "Math", "John Doe"),
            new Course(2, "English", "Carl Max")
        );
    }
}
