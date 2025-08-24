// package mutilthreading;

public class F_Synchronization {
    public static void main(String[] args) {
        Counter counter = new Counter();
        System.out.println("Counter value: " + counter.getCounter());
        // counter.incrementCounter();
        // System.out.println("Counter value: " + counter.getCounter());

        // two threads and passing common counter object
        Worker w1 = new Worker(counter);
        Worker w2 = new Worker(counter);
        w1.start();
        w2.start();
        try {
            w1.join();
            w2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("After completion of both threads");
        System.out.println("Counter value: " + counter.getCounter());
    }
}

class Worker extends Thread {
    private Counter counter;

    Worker (Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        for (int i=0; i<1000; i++) {
            // this.counter.incrementCounter();
            this.counter.synchronizedIncrementCounter();
        }
    }
}
class Counter {
    private int counter = 0;

    // to fix the problem of random final counter value 
    // we can synchronize this function
    public void incrementCounter() {
        counter++;
    }
    // synchronized increment counter
    public synchronized void synchronizedIncrementCounter() {
        counter++;
    }
    public int getCounter() {
        return counter;
    }
}
