// package N_executor_framework;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class B_WithExecutorFramework {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        B_WithExecutorFramework.first10NumFactorialExecutor();
        // we also need to shutdown the executorService
        long endTime = System.currentTimeMillis();
        System.out.println("Executor service took: " + (endTime - startTime) + "ns.");
        
    }
    public static void first10NumFactorialExecutor() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i=0; i<10; i++) {
            int finalI = i;
            executorService.submit(() -> System.out.println(factorialCalc(finalI)));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static int factorialCalc(int num) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        if (num <=1) {
            return num;
        }
        return num * factorialCalc(num-1);
    }
}

