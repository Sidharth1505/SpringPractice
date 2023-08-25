package com.in28minutes.springin5steps;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BubbleSortAlgorithm implements SortAlgorithm{
    public int[] sort(int [] numbers) {
        return numbers;
    }
}
