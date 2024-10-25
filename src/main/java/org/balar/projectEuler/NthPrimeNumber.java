package org.balar.projectEuler;

public class NthPrimeNumber {
    public void run() {
        int n = 10001;
        System.out.println(getNthPrime(n));
    }
    
    private int getNthPrime(int limit) {
        int count = 1;
        for (int i = 2; true; i++) {
            if (isPrime(i)) {
                count++;
                if (count == limit) {
                    return i;
                }
            }
        }
    }
    
    private boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
