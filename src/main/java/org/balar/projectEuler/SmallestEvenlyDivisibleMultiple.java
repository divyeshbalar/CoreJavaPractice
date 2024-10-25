package org.balar.projectEuler;

import java.util.stream.IntStream;

public class SmallestEvenlyDivisibleMultiple {
    public void run() {
        long endTime = 0L;
        long startTime = System.currentTimeMillis();
        System.out.println(IntStream.range(40, Integer.MAX_VALUE)
                .boxed()
                .parallel()
                .filter(
                        i -> i % 20 == 0 &&
                                i % 19 == 0 &&
                                i % 18 == 0 &&
                                i % 17 == 0 &&
                                i % 16 == 0 &&
                                i % 15 == 0 &&
                                i % 14 == 0 &&
                                i % 13 == 0 &&
                                i % 12 == 0 &&
                                i % 11 == 0).findFirst());
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
