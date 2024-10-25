package org.balar.projectEuler;

public class ProductOfPythagoreanTriplets {
    public void run() {
        for (int a = 1; a <= 333; a++) {
            for (int b = 1; b <= 500; b++) {
                int c = (int) Math.sqrt((a * a) + (b * b));
                if (a + b + c == 1000) {
                    System.out.format("Hello %d:a  %d:b %d:c %d:Result\n", a, b, c, a * b * c);
                }
            }
        }
    }
}
