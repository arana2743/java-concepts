import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class C_ScheduledExecutorService {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(
            () -> System.out.println("Scheduled after 5 secs delay!"),
            5,
            TimeUnit.SECONDS
        );
        // another method - to schedule at regular interval
        scheduler.scheduleAtFixedRate(
            () -> System.out.println("Scheduled at every 3 secs delay!"), 
            0, 
            3,
            TimeUnit.SECONDS
        );

        // another method - to schedule at regular delay
        // this is such that it will not wait for any previous task to complete post give delay
        // if task is not completed within delay then don't wait and launch next
        scheduler.scheduleWithFixedDelay(
            () -> System.out.println("scheduled with a 2 second delay"),
            0,
            2,
            TimeUnit.SECONDS
        );
        // we cannot use below shutdown with scheuled executor
        // scheduler.shutdown();
        // we do shutdown like below
        scheduler.schedule(
            () -> {
                System.out.println("initiating shutdown...");
                scheduler.shutdown();
            },
            15,
            TimeUnit.SECONDS);
    }    
}
