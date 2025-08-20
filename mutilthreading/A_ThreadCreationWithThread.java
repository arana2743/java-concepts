// package mutilthreading;

public class A_ThreadCreationWithThread {
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();
        for (int i=0; i<=5; i++) {
            System.out.println("Main thread");
        }
    }
}

class Worker extends Thread {
    @Override
    public void run() {
        for (int i=0; i<=5; i++) {
            System.out.println("Worker thread");
        }
    }
}
