import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class H_CompletableFutureWithExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            for (int i=1; i<=5; i++) {
                try{
                    Thread.sleep(2000);
                    System.out.println("future1: " + i);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            return "ok";
        }, executorService);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            for (int i=6; i<=10; i++) {
                System.out.println("future2: " + i);
                
            }
            return "ok";
        }, executorService);
        CompletableFuture<Void> finalFuture = CompletableFuture.allOf(future1, future2);
        try{
            System.out.println("final future get: " + finalFuture.get());
        } catch(InterruptedException | ExecutionException e) {
            System.out.println(e);
        }
        System.out.println("MAIN");

    }
}
