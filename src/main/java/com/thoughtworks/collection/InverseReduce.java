package com.thoughtworks.collection;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        int bound = 3;
        List<Integer> result = new ArrayList<>();
        while (number >= 2) {
            number -= random.nextInt(bound);
            result.add(number);
        }
        return result;
    }
}
