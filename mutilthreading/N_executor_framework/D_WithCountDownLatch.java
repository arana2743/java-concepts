import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.CountDownLatch;

public class D_WithCountDownLatch {
    public static void main(String[] args) {
        final int threadTotalCount = 10;
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(threadTotalCount);
        for (int i=0; i<10; i++) {
            executor.submit(new DependentService(countDownLatch));
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("back to main...");
        executor.shutdown();
    }
}

class DependentService implements Callable<String> {
    private final CountDownLatch countDownLatch;

    public DependentService(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public String call() {
        try{
            Thread.sleep(2000);
            System.out.println("Running thread after 2 secs sleep.");  
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(e);
        } finally {
            countDownLatch.countDown();
        }
        return "ok";
    }
}