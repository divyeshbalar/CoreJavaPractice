package org.balar.coreJavaBasics.multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadingPractice {
    // Ideally java app run on a single thread named main thread
    // MultiThreading can be achieved using either extending a Thread class OR implementing a Runnable interface OR using ExecutorService
    // Thread lifecycle
    /*
        1> new: Thread t1 = new Thread();
        2> Runnable: t1.start(); it moves the thread to runnable state
        3> Thread Scheduler will pick one of the thread from Runnable state and will execute it which will lend it to Running state
        4> Running: the thread gets execute here and if a thread is waiting for any i/o or network request or memory or computation, Thread schedular will change its state to not running
        5> Not Running: it contains the threads which are waiting for some i/o or network request or memory, once ready, it will again go to runnable state.
        6> Terminated: it is a state when the run() method has exited
     */
    
    private static void extracted() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Task1: " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    public void main() {
        //Using Thread Class
        Thread t1 = new Task1();
        Thread t2 = new Task2();
//        t1.start();
//        t2.start();
        
        //Using Runnable interface
        Runnable r1 = new Task1Runnable();
        Runnable r2 = new Task2Runnable();
        Thread rt1 = new Thread(r1);
        Thread rt2 = new Thread(r2);
//        rt1.start();
//        rt2.start();
        
        //Threading using lambda expression
        Runnable r11 = () -> {
            extracted();
        };
        
        //Thread using annonymous inner class implementing Runnable above
        Thread rt11 = new Thread(r11);
        //Thread using the labda expression since the Runnable is the Functional interface
        Thread rt12 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("Task2: " + i + Thread.currentThread().getPriority());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        rt11.start();
        rt12.start();
        
        // Join and isAlive
        // Basically when the 2 new thread gets forked from the main thread, now, if finishing the execution of these two thread is mandatory in order to continue running the main thread
        // then in that case, we can run thread.join(); to let the thread finish and join back the main thread.
        //For ex: because we wrote .join(), the main thread will wait for those 2 thread to finish the execution and join back the parent/main thread and then will execute the println()
//        try {
//            System.out.println("rt12 Thread isAlive: ?" + rt12.isAlive());
//            rt11.join();
//            rt12.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Status of the rt11 thread: isAlive? " + rt11.isAlive() + "\nIt must print once both of the Child threads are done running!");
        
        
        // Name Thread and Priority of the thread
        rt11.setPriority(Thread.MAX_PRIORITY);
        rt12.setPriority(Thread.MIN_PRIORITY);
        System.out.println(rt11.getName());
        System.out.println(rt12.getName());
        rt11.setName("Tast1Thread");
        rt12.setName("Test2Thread");
        System.out.println(rt11.getName());
        System.out.println(rt12.getName());
        
        
        //implements MultiThreading using ExecutorService
        
        System.out.println("Executing the thread using executor service");
        final ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(MultiThreadingPractice::extracted);
    }
    
    
}

class Task1 extends Thread {
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Task1: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Task2 extends Thread {
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Task2: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Task1Runnable implements Runnable {
    
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Task1Runnable: " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Task2Runnable implements Runnable {
    
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Task2Runnable: " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}