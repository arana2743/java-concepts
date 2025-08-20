// package mutilthreading;

public class B_ThreadStates {
    public static void main(String[] args) {
        Worker worker = new Worker();
        System.out.println(worker.getState()); // should be NEW
        worker.start();
        System.out.println(worker.getState()); // should be RUNNABLE
        try{
            Thread.sleep(100);
        } catch (InterruptedException e){
            System.out.println("Exception for interrupt: " + e);
        }
        System.out.println(worker.getState()); // should be TIMED_WAITING
        // this will allow the main to wait for worker to complete before running next line
        try {
            worker.join();
        } catch (InterruptedException e) {
            System.out.println("Exception for interrupt: " + e);
        }
        System.out.println(worker.getState()); // should be TERMINATED
    }
}

class Worker extends Thread {
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Exception for interrupt: " + e);
        }
        System.out.println("Thread state from worker: " + Thread.currentThread().getState());
        System.out.println("Worker thread");
    }
}