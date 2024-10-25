package org.balar.projectEuler;

public class EvenFibonacciNumber {
    
    public static int getFibboSum() {
        int opSum = 2;
        int val1 = 1, val2 = 2, sum = 0;
        while (sum <= 4000000) {
            sum = val1 + val2;
            val1 = val2;
            val2 = sum;
            if (sum % 2 == 0) {
                opSum += sum;
            }
        }
        return opSum;
    }
    
    public void run() {
        System.out.println(getFibboSum());
    }
}
