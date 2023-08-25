package com.in28minutes.springin5steps;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice for 15 minutes daily";
    }
}
