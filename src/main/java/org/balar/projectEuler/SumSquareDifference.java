package org.balar.projectEuler;

import java.util.stream.IntStream;

public class SumSquareDifference {
    public void run() {
        final int limit = 100;
        System.out.println(getSumOfSquareOfNNumbers(limit) - getSquareOfSumOfNNumbers(limit));
    }
    
    private int getSumOfSquareOfNNumbers(int limit) {
        return IntStream.range(1, limit + 1).boxed().parallel().map(x -> x * x).reduce(0, Integer::sum);
    }
    
    private int getSquareOfSumOfNNumbers(int limit) {
        int op = (IntStream.range(1, limit + 1).boxed().parallel().reduce(0, Integer::sum));
        return op * op;
    }
}
