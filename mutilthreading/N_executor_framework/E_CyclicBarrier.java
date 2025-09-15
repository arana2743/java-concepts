import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;

public class E_CyclicBarrier {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CyclicBarrier barrier = new CyclicBarrier(
            3,
            () -> System.out.println("barrier is tripped, will move to main")
        );
        for (int i=0; i<3; i++) {
            executor.submit(new DependentService(barrier));
        }
        System.out.println("main");
        executor.shutdown();
    }    
}

class DependentService implements Callable<String> {
    private CyclicBarrier cyclicBarrier;

    public DependentService(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public String call() {
        try {
            System.out.println(Thread.currentThread().getName() + " is running...");
            Thread.sleep(2000);
            this.cyclicBarrier.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(e);
        }
        return "ok";
    }
}