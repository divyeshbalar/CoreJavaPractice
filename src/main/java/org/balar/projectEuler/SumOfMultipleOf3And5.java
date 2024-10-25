package org.balar.projectEuler;

import java.util.stream.IntStream;

public class SumOfMultipleOf3And5 {
    private static final int RANGE = 1000;
    
    public void run() {
        System.out.println(IntStream.range(1, RANGE).boxed().toList().stream().filter(x -> x % 3 == 0 || x % 5 == 0).reduce(0, (x, y) -> x + y));
    }
}
