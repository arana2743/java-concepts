import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class G_CompletableFuture {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(
            () -> {
                try{
                    Thread.sleep(2000);
                    System.out.println("Supplier thread");
                } catch(InterruptedException e) {
                    System.out.println(e);
                }
                return "ok";   
        });
        try {
            String result = completableFuture.get();
            System.out.println("result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }
        
        System.out.println("MAIN");
    }
}
