// package mutilthreading;

public class D_ThreadInterrupt {
    public static void main(String[] args) {
        Worker w1 = new Worker();
        w1.start();
        w1.interrupt(); // this make the InterruptedException block run
    }
}

class Worker extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println("Thread is running...");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted exception: " + e);
        }
        System.out.println("Thread is finished...");
    }
}
