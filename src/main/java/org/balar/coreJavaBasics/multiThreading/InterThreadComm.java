package org.balar.coreJavaBasics.multiThreading;

public class InterThreadComm {
    //using semaphore logic
    public void start() {
        ResourceData rd = new ResourceData();
        new Producer(rd);
        new Consumer(rd);
    }
    
    
}

class Producer implements Runnable {
    ResourceData resource;
    
    public Producer(ResourceData resource) {
        this.resource = resource;
        Thread t1 = new Thread(this, "Producer");
        t1.start();
    }
    
    @Override
    public void run() {
        int i = 0;
        while (true) {
            this.resource.setI(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        
    }
}

class Consumer implements Runnable {
    ResourceData resource;
    
    public Consumer(ResourceData resource) {
        this.resource = resource;
        Thread t2 = new Thread(this, "Consumer");
        t2.start();
    }
    
    @Override
    public void run() {
        while (true) {
            this.resource.getI();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        
    }
}

class ResourceData {
    int i = 0;
    boolean isSet = false;
    
    public synchronized void getI() {
        while (!isSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            
        }
        System.out.println("get: " + i);
        isSet = false;
        notify();
        
    }
    
    public synchronized void setI(int i) {
        while (isSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        
        this.i = i;
        System.out.println("Set: " + this.i);
        isSet = true;
        notify();
        
    }
}