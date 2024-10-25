package org.balar.coreJavaBasics.multiThreading;

public class RunnerClass {
    public void start() {
        SynchronizeDemo sd = new SynchronizeDemo();
        //Both thread are trying to consume and modify the shared resource through a method
        Thread t1 = new Thread(() -> {
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
            for (int i = 0; i < 100000; i++) {
                sd.consumeResourceAndIncrement();
            }
        });
        Thread t2 = new Thread(() -> {
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
            for (int i = 0; i < 1000000; i++) {
                sd.consumeResourceAndIncrement();
            }
        });
        
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(SynchronizeDemo.resource);
        
    }
}
