import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

public class F_CyclicBarrierExample {
    public static void main(String[] args) {
        int numOfSubSystems = 4;
        CyclicBarrier barrier = new CyclicBarrier(
            numOfSubSystems,
            () -> System.out.println("All services are up and running now.")
        );

        // example of variable threads taking varible time
        // and condition is to wait for all threads to finish before moving to next step
        Thread webServerThread = new Thread(new SubSystem("Web Server", 2000, barrier));
        Thread databaseThread = new Thread(new SubSystem("DataBase", 4000, barrier));
        Thread cacheThread = new Thread(new SubSystem("Cache", 3000, barrier));
        Thread messagingServiceThread = new Thread(new SubSystem("Messaging Service", 4500, barrier));

        webServerThread.start();
        databaseThread.start();
        cacheThread.start();
        messagingServiceThread.start();

        System.out.println("main");

    }   
}

class SubSystem implements Runnable {
    private String name;
    private int initializationTime;
    private CyclicBarrier cyclicBarrier;

    public SubSystem(String name, int initializationTime, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.initializationTime = initializationTime;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " initialization started...");
            Thread.sleep(this.initializationTime);
            System.out.println(this.name + " initialization completed...");
            this.cyclicBarrier.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            System.out.println(e);
            Thread.currentThread().interrupt();
        }
    }
}