package org.balar.coreJavaBasics.multiThreading;

public class SynchronizeDemo {
    public static int resource = 0; //shared resource
    
    //Making the method synchronized make the operation thread safe and does not let the other thread enter the method area while one thread is doing its task
    public synchronized void consumeResourceAndIncrement() {
        resource++;
    }
}

