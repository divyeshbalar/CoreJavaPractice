package org.balar.coreJavaBasics.dataStructurePractice.searching;

import java.util.stream.IntStream;

public class BinarySearch {
    public void run() {
        int[] arr = IntStream.range(1, 10000000).toArray();
//                {2, 3, 5, 6, 7, 8, 11, 13, 14, 16, 16, 17, 17, 19};
        
        int target = 123;

//        int resultIndex = getIndexNumberOf(arr, target);
        int resultIndex = binarySearch(arr, target, 0, arr.length - 1);
        System.out.println(arr[resultIndex]);
        
    }
    
    //Binary Search using recursion
    private int binarySearch(int[] arr, int target, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (target == arr[mid]) {
                System.out.println("Binary Search with Recursion, Index: " + mid);
                return mid;
            } else if (target < arr[mid]) {
                return binarySearch(arr, target, left, mid - 1);
            } else {
                return binarySearch(arr, target, mid + 1, right);
            }
        }
        return -1;
    }
    
    
    //Binary search
    private int getIndexNumberOf(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        int mid = (left + right) / 2;
        int steps = 0;
        
        while (left <= right) {
            steps++;
            if (target == arr[mid]) {
                System.out.println("Binary Search Steps : " + steps);
                return mid;
            }
            if (target < arr[mid]) {
                right = mid - 1;
            }
            if (target > arr[mid]) {
                left = mid + 1;
            }
            mid = (right + left) / 2;
        }
        return -1;
    }
}
