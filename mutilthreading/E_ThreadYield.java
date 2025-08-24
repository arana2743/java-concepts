// package mutilthreading;

public class E_ThreadYield {
    public static void main(String[] args) {
        Worker w1 = new Worker();
        Worker w2 = new Worker();
        w1.start();
        w2.start();
    }
}

class Worker extends Thread {
    @Override
    public void run() {
        for(int i=1; i<6; i++) {
            System.out.println(Thread.currentThread().getName() + " is running count: " + i);
            Thread.yield(); // hint to OS Scheduler to let other thread run
        }
    }
}