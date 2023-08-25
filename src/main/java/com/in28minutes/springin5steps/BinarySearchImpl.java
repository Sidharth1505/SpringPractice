package com.in28minutes.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {
    @Autowired
    private SortAlgorithm sortAlgorithm;
    public BinarySearchImpl(final SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }
    public int binarySearch(int [] numbers, int numbertoSearchFor) {
        int [] sortedNumbers = sortAlgorithm.sort(numbers);
        System.out.println(sortedNumbers);
        return 3;
    }
}
