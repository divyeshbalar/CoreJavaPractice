package org.balar.coreJavaBasics.dataStructurePractice.searching;

import java.util.stream.IntStream;

public class LinearSearch {
    public void run() {
        int[] arr = IntStream.range(1, 10000000).toArray();
//                {2, 3, 5, 6, 7, 8, 11, 13, 14, 16, 16, 17, 17, 19};
        int target = 317;
        
        int resultIndex = getIndexNumberOf(arr, target);
        System.out.println(arr[resultIndex]);
    }
    
    private int getIndexNumberOf(int[] arr, int target) {
        int steps = 0;
        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (target == arr[i]) {
                System.out.println("Linear Search Steps : " + steps);
                return i;
            }
        }
        return -1;
    }
}
