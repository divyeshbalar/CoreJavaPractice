package org.balar.coreJavaBasics.dataStructurePractice.sorting;

import java.util.stream.IntStream;

public class sortingAlgon {
    public void run() {
        int[] arr = IntStream.generate(() -> (int) (Math.random() * 10)).limit(10).toArray();
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println("\n-----------");
        bubbleSort(arr);
    }
    
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            for (int item : arr) {
                System.out.print(item + " ");
            }
            System.out.println();
            
        }
    }
}
