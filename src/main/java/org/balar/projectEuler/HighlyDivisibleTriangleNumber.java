package org.balar.projectEuler;

import java.util.*;
import java.util.stream.LongStream;

public class HighlyDivisibleTriangleNumber {
    public static int isprime(int n) {
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return 0;
        }
        
        return 1;
    }
    
    public static List<Integer> primeFactors(long n) {
        List<Integer> listOfPrimeFactorials = new ArrayList<>();
        
        for (int i = 2; i <= n; i++) {
            if (isprime(i) == 1) {
                long x = n;
                while (x % i == 0) {
                    listOfPrimeFactorials.add(i);
                    System.out.print(i + " ");
                    x /= i;
                }
            }
        }
        return listOfPrimeFactorials;
        
    }
    
    public void run() {
        
        System.out.println(LongStream.range(76576499, Long.MAX_VALUE).boxed().map(x -> (x * (x + 1)) / 2).filter(this::areDevisorMoreThan500).findFirst());
        
    }
    
    private boolean areDevisorMoreThan500(long num) {
        int factorsCount = 1;
        
        System.out.println("\nTriangle Number = " + num);
        List<Integer> listOfPrimeFactors = primeFactors(num);
        
        System.out.println("\nListOfPrimeFactors = " + listOfPrimeFactors);
        Map<Integer, Integer> primeToCount;
        primeToCount = findUniquePrimesAndCount(listOfPrimeFactors);
        for (int key : primeToCount.keySet()) {
            factorsCount = factorsCount * primeToCount.get(key);
        }
        
        System.out.println("\nNumber of Factors are = " + factorsCount);
        return factorsCount > 500;
        
    }
    
    private Map<Integer, Integer> findUniquePrimesAndCount(List<Integer> listOfPrimeFactors) {
        Map<Integer, Integer> opMap = new HashMap<>();
        List<Integer> uniquePrimes = listOfPrimeFactors.stream().distinct().toList();
        for (int i : uniquePrimes) {
            opMap.put(i, Collections.frequency(listOfPrimeFactors, i) + 1);
        }
        System.out.println(opMap);
        return opMap;
    }


//    private boolean areDevisorMoreThan500(long num) {
//        //Finding prime factorization
//        List<Integer> listOfPrimeFactor = new ArrayList<>();
//        while (num != 1) {
//            if (num % 2 == 0) {
//                listOfPrimeFactor.add(2);
//                num = num / 2;
//            } else if (num % 3 == 0) {
//                listOfPrimeFactor.add(3);
//                num = num / 3;
//            } else if (num % 5 == 0) {
//                listOfPrimeFactor.add(5);
//                num = num / 5;
//            } else if (num % 7 == 0) {
//                listOfPrimeFactor.add(7);
//                num = num / 7;
//            } else {
//                System.out.println("last factor Prime Number: " + num);
//                num = 1;
//            }
//        }
//        System.out.println(listOfPrimeFactor);
//        long exponent2 = listOfPrimeFactor.stream().filter(i -> i % 2 == 0).count() + 1;
//        long exponent3 = listOfPrimeFactor.stream().filter(i -> i % 3 == 0).count() + 1;
//        long exponent5 = listOfPrimeFactor.stream().filter(i -> i % 5 == 0).count() + 1;
//        long exponent7 = listOfPrimeFactor.stream().filter(i -> i % 7 == 0).count() + 1;
//        System.out.println("number of factors: " + (exponent2 * exponent3 * exponent7 * exponent5) + "\n");
//        return (exponent2 * exponent3 * exponent5 * exponent7) > 500;
//    }
}
