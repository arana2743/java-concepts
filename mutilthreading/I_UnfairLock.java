// package mutilthreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class I_UnfairLock {
    public static void main(String[] args) {
        FairnesslockExample example = new FairnesslockExample();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };
        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                example.accessResourceWithFairness();
            }
        };
        Thread t1 = new Thread(task2, "Thread 1");
        Thread t2 = new Thread(task2, "Thread 2");
        Thread t3 = new Thread(task2, "Thread 3");
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class FairnesslockExample {
    private final Lock unfairLock = new ReentrantLock();
    // we can make a lock fair with argument like below:
    private final Lock fairLock = new ReentrantLock(true);

    public void accessResource() {
        unfairLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " released the lock.");
            unfairLock.unlock();
        }
    }

    public void accessResourceWithFairness() {
        fairLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " released the lock.");
            fairLock.unlock();
        }
    }
}
