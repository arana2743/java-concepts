import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class D_WithoutCountDownLatch {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<String> future1 = executor.submit(new DependentService());
        Future<String> future2 = executor.submit(new DependentService());
        Future<String> future3 = executor.submit(new DependentService());
        // below is the way how we can main thread to wait for all executors to finish
        try {
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("shutting down executor...");
        executor.shutdown();
    }
}

class DependentService implements Callable<String> {
    @Override
    public String call() {
        try {
            Thread.sleep(2000);
            System.out.println("Running thread after 2 secs sleep");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        return "ok";
    }
}