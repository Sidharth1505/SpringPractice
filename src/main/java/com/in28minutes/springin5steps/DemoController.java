package com.in28minutes.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private Coach cricketCoach;

    public DemoController(Coach cricketCoach) {
        this.cricketCoach = cricketCoach;
    }

    @GetMapping("/dailyworkout")
    public String temp() {
        return cricketCoach.getDailyWorkout();
    }
}
