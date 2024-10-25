package org.balar.projectEuler;

public class Largest3DigitPalindromeProduct {
    public void run() {
        int max = 0;
        for (int i = 999; i > 99; i--) {
            for (int j = 999; j > 99; j--) {
                if (isPalindrome(i * j)) {
                    System.out.format("%d and %d product is a Palidrome: %d\n", i, j, (i * j));
                    max = Math.max(max, i * j);
                }
            }
        }
        System.out.println("MAX Number is: " + max);
        
    }
    
    private boolean isPalindrome(int i) {
        return getReverseNumber(i) == i;
    }
    
    public int getReverseNumber(int num) {
        int reverse = 0;
        while (num != 0) {
            reverse = (reverse * 10) + (num % 10);
            num = num / 10;
        }
        return reverse;
    }
}
