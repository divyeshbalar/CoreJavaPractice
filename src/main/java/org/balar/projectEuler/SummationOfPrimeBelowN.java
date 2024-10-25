package org.balar.projectEuler;

import java.util.stream.LongStream;

public class SummationOfPrimeBelowN {
    public void run() {
        final long limit = 2_000_001L;
        System.out.println(LongStream.range(2, limit).boxed().parallel().filter(this::isPrime).reduce(0L, Long::sum) + 2);
    }
    
    private boolean isPrime(Long aLong) {
        for (long i = 2; i < Math.sqrt(aLong) + 1; i++) {
            if (aLong % i == 0) {
                return false;
            }
        }
        return true;
    }
}
