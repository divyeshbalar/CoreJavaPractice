package org.balar.projectEuler;

public class LargestPrimeFactor {
    
    public static final long INPUTE_NUMBER = 600851475143L;
    long startTime = System.currentTimeMillis();
    long endTime = 0L;
    
    public void run() {
        long max = 0L;
        
        //MilliSeconds 4151
//        for (long i = 2; i < Math.sqrt(INPUTE_NUMBER); i++) {
//            System.out.println(i);
//            if (INPUTE_NUMBER % i == 0) {
//                if (isPrime(i)) {
//                    System.out.println(i);
//                    max = Math.max(max, i);
//                }
//            }
//        }
//
        //Milliseconds 3431
        for (long i = (long) Math.sqrt(INPUTE_NUMBER); i >= 2; i--) {
            System.out.println(i);
            if (INPUTE_NUMBER % i == 0) {
                if (isPrime(i)) {
                    System.out.println(i);
                    max = Math.max(max, i);
                    break;
                }
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("TIME : " + ((endTime - startTime)) + " OP : " + max);
    }
    
    private boolean isPrime(long num) {
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
