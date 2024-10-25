package org.balar.coreJavaBasics.dataStructurePractice;

public class IntDynamicArrayDs {
    /*
    The array object must let you add an element 
        1. at the end
        2. at the beginning
        3. in the middle of the array
        
        Default size of the array 5
        
        expand the array dynamically:
            1. when more than 50%of the current capacity is full -> add +50% of and transfer the data to new one 
     */
    
    int[] arr;
    private int capacity = 5;
    private int headPointer;
    
    
    public IntDynamicArrayDs() {
        //Default size = 5 elements
        this.arr = new int[capacity];
        headPointer = 0;
    }
    
    //Adding data
    
    public void add(int data) {
        this.addToLast(data);
    }
    
    public void add(int data, int indexAt) {
        if (indexAt == 0) {
            this.addToFirst(data);
        } else {
            //get to the index, add the data and re-arrange the data after that index
        }
        //
        
    }
    
    public void addToFirst(int data) {
        //Add to first and rearrange the array
    }
    
    public void addToLast(int data) {
    }
    
    // Removing Data
    public void remove(int data) {
        //Default is to remove first occurance and rearrage the array
        this.removeFirst(data);
    }
    
    
    public void removeFirst(int data) {
        //remove the very first occurance of the data and rearrage the array
    }
    
    
    public void removeAll(int data) {
        //remove all occurance of the data and rearrange the array
    }
}
