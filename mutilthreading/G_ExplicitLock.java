// package mutilthreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class G_ExplicitLock {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        // bankAccount.withdraw(20);

        // create a implementation of Runnable interface
        // using anonymous class
        Runnable task = new Runnable() {
            @Override
            public void run() {
                bankAccount.withdraw(20);
            }
        };
        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                bankAccount.withdrawWithLock(20);
            }
        };
        // now create thread using above implementation
        Thread t1 = new Thread(task2, "Thread 1");
        Thread t2 = new Thread(task2, "Thread 2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("All done.");
    }
}

class BankAccount {
    private int balance = 100;

    private final Lock lock = new ReentrantLock(); // we can also set it as final
    
    // with synchronized
    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " is attempting to withdraw amount: " + amount);
        if (this.balance < amount) {
            System.out.println("Insufficient balance");
            return ;
        }
        System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal.");
        try {
            Thread.sleep(3000);
        } catch(InterruptedException e){
            System.out.println(e);
        }
        this.balance -= amount;
        System.err.println(Thread.currentThread().getName() +  " withdrawal completed. Remaining balance: " + this.balance);
    }

    // with explicit lock
    public void withdrawWithLock(int amount) {
        try{
            if (this.lock.tryLock(3, TimeUnit.SECONDS)) {
                if (this.balance < amount) {
                    System.out.println("Insufficient balance.");
                    return ;
                }
                System.out.println(Thread.currentThread() + " proceeding with withdrawal.");
                try{
                    Thread.sleep(3000);
                    this.balance -= amount;
                    System.out.println(Thread.currentThread().getName() + " withdrawal completed. Remaining balance: " + this.balance);
                } catch (Exception e) {
                    System.out.println(e);
                    // good practive to interrupt the thread to save it's interrupted state
                    Thread.currentThread().interrupt();
                } finally {
                    this.lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire lock, will try again later...");
            }
        } catch (InterruptedException e) {
            System.out.println(e);
            // good practive to interrupt the thread to save it's interrupted state
            Thread.currentThread().interrupt();
        }
    }
}