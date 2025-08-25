// package mutilthreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class J_ReadWriteLock {
    public static void main(String[] args) {
        ReadWriteCounter readWriteCounter = new ReadWriteCounter();
        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<5; i++) {
                    System.out.println(Thread.currentThread().getName() + " reading counter: " + readWriteCounter.getCount());
                }
            }
        };
        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<5; i++) {
                    readWriteCounter.increment();
                    System.out.println(Thread.currentThread().getName() + " incremented counter.");
                }
            }
        };

        Thread t1 = new Thread(readTask, "Thread 1");
        Thread t2 = new Thread(writeTask, "Thread 2");
        Thread t3 = new Thread(readTask, "Thread 3");
        t1.start();
        t2.start();
        t3.start();
        try{
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Final count: " + readWriteCounter.getCount());
    }   
}

class ReadWriteCounter {
    private int count = 0;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void increment() {
        writeLock.lock();
        try {
            this.count++;
        } finally {
            writeLock.unlock();
        }
    }
    public int getCount() {
        readLock.lock();
        try {
            return this.count;
        } finally {
            readLock.unlock();
        }
    }
}