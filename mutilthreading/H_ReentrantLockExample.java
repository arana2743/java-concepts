// package mutilthreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class H_ReentrantLockExample {
    public static void main(String[] args) {
        ReentrantExample ex = new ReentrantExample();
        // ex.outerMethod();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                ex.outerMethod();
            }
        };
        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class ReentrantExample {
    private final Lock lock = new ReentrantLock();

    public void outerMethod() {
        this.lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": In Outer method.");
            this.innerMethod();
        } finally {
            this.lock.unlock();
        }
    }

    public void innerMethod() {
        this.lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": In Inner method.");
        } finally {
            this.lock.unlock();
        }
    }
}
