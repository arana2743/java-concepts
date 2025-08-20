// package mutilthreading;

public class A_ThreadCreationWithRunnable {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread t1 = new Thread(worker);
        t1.start();
        System.out.println("Main thread");
    }
}

class Worker implements Runnable {
    @Override
    public void run() {
        System.out.println("Worker thread using Runnable.");
    }
}
