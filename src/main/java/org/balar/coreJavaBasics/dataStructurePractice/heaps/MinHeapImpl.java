package org.balar.coreJavaBasics.dataStructurePractice.heaps;

import java.util.Arrays;

public class MinHeapImpl implements Heap, Comparable<MinHeapImpl> {
    
    int capacity;
    int size = 0;
    int[] heapDs;
    
    public MinHeapImpl(int capacity) {
        this.capacity = capacity;
        heapDs = new int[capacity];
    }
    
    @Override
    public String toString() {
        return "MinHeapImpl{" +
                "capacity=" + capacity +
                ", size=" + size +
                ", heapDs=" + Arrays.toString(heapDs) +
                '}';
    }
    
    @Override
    public boolean hasLeftChild(int parentIndex) {
        return getLeftChildIndex(parentIndex) < capacity;
    }
    
    @Override
    public boolean hasRightChild(int parentIndex) {
        return getRightChildIndex(parentIndex) < capacity;
    }
    
    @Override
    public boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) <= capacity;
    }
    
    @Override
    public void swap(int to, int from) {
        int temp = heapDs[to];
        heapDs[to] = heapDs[from];
        heapDs[from] = temp;
    }
    
    private void ensureExtraCapacity() {
        if (size == capacity) {
            heapDs = Arrays.copyOf(heapDs, capacity * 2);
            capacity *= 2;
        }
    }
    
    @Override
    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }
    
    @Override
    public int getLeftChildIndex(int parentIndex) {
        return (2 * parentIndex) + 1;
    }
    
    @Override
    public int getRightChildIndex(int parentIndex) {
        return (2 * parentIndex) + 2;
    }
    
    @Override
    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && heapDs[index] < heapDs[getParentIndex(index)]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
            System.out.println("\t" + this);
        }
    }
    
    @Override
    public void heapifyDown() {
        int index = 0;
        int smallerElementIndex = 0;
        while (hasLeftChild(index)) {
            smallerElementIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && heapDs[smallerElementIndex] > heapDs[getRightChildIndex(index)]) {
                smallerElementIndex = getRightChildIndex(index);
            }
            if (heapDs[index] < heapDs[smallerElementIndex] || smallerElementIndex >= size - 1) {
                break;
            } else {
                swap(index, smallerElementIndex);
            }
            
            index = smallerElementIndex;
            System.out.println("\t" + this);
        }
        
    }
    
    @Override
    public void add(int element) {
        System.out.println(this);
        ensureExtraCapacity();
        heapDs[size] = element;
        size++;
        if (size > 1) {
            heapifyUp();
        }
        
    }
    
    @Override
    public void remove() {
        System.out.println(this);
        heapDs[0] = heapDs[size - 1];
        heapDs[size - 1] = 0;
        size--;
        heapifyDown();
    }
    
    @Override
    public int compareTo(MinHeapImpl o) {
        return 0;
    }
}


/*
    
    //    private boolean isMFAattckInProgress(List<Log> listOfEvents, int minutesThreshold, int percentThreshold, int attempsThreshold) {
//
//        int numberOfEntries = listOfEvents.size();
//        LocalDateTime intiTime = listOfEvents.get(numberOfEntries - 1).timeStamp;
//        int thresholdCountDown = attempsThreshold;
//        int failureCount = 0;
//
//
//        for (int i = numberOfEntries - 2; i >= 0; i--) {
//            Log temp = listOfEvents.get(i);
//            long minutes = Math.abs(getTime(intiTime, temp.timeStamp));
//            if (thresholdCountDown > 0 && minutes <= minutesThreshold) {
//                if (!temp.status) {
//                    failureCount++;
//                }
//            } else {
//                int totalReqParsed = numberOfEntries - i;
//                //Checking the percentage of failure in last 5 min
//                if (failureCount / totalReqParsed > percentThreshold) {
//                    return true;
//                }
//            }
//            attempsThreshold--;
//            if (thresholdCountDown == -1) {
//                break; // Stop checking once the threshold is reached
//            }
//
//        }
//        return false;
//    }
//
//
//}
 */