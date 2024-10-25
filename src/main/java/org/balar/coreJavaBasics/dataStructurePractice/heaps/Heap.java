package org.balar.coreJavaBasics.dataStructurePractice.heaps;

public interface Heap {
    boolean hasLeftChild(int parentIndex);
    
    boolean hasRightChild(int parentIndex);
    
    boolean hasParent(int childIndex);
    
    
    void swap(int to, int from);
    
    
    int getParentIndex(int childIndex);
    
    int getLeftChildIndex(int parentIndex);
    
    int getRightChildIndex(int parentIndex);
    
    
    void heapifyUp();
    
    void heapifyDown();
    
    void add(int element);
    
    void remove();
    
}
