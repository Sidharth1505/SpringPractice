package com.in28minutes.springin5steps;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Controller
public class CourseContoller {

    @RequestMapping("/course")
    @ResponseBody
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1, "Learn AWS", "in28Minutes"),
                new Course(2, "Learn DevOps", "in28Minutes")
        );
    }
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello Worl";
    }


    @RequestMapping("new")
    public String sayHelloJsp() {
        return "sayHello";
    }

}
