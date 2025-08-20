// package mutilthreading;

public class C_ThreadNameAndPriority {
    public static void main(String[] args) {
        Worker w1 = new Worker("Highest Priority Work");
        Worker w2 = new Worker("Medium Priority Work");
        Worker w3 = new Worker("Lowest Priority Work");
        // start the threads
        // w1.start();
        // w2.start();
        // w3.start();
        // by default threads have NORM_PRIORITY

        // now setting priority 
        w1.setPriority(Thread.MAX_PRIORITY);
        w2.setPriority(Thread.NORM_PRIORITY);
        w3.setPriority(Thread.MIN_PRIORITY);

        // now again starting threads
        w1.start();
        w2.start();
        w3.start();
    }
}

class Worker extends Thread {
    // to set name we can set a constructor here and pass name to super()
    Worker(String tName) {
        super(tName);
    }
    @Override
    public void run() {
        String cThreadName = Thread.currentThread().getName();
        int cThreadPriority = Thread.currentThread().getPriority();
        System.out.println("Thread name: " + cThreadName + ", has priority: " + cThreadPriority);
    }
}
