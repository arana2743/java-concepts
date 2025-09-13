// package N_executor_framework;

public class A_WithoutExecutorFramework {
    public static void main(String[] args) {
        System.out.println(factorialCalc(5));
        System.out.println("print factorial of first 10 natural numbers");
        System.out.println("Calculcating serially:");
        long startTime = System.currentTimeMillis();
        A_WithoutExecutorFramework.first10NumFactorialSerial();
        long endTime = System.currentTimeMillis();
        System.out.println("Serial took: " + (endTime - startTime) + " ns.");

        startTime = System.currentTimeMillis();
        A_WithoutExecutorFramework.first10NumFactorialParallel();
        endTime = System.currentTimeMillis();
        System.out.println("Parallel took: " + (endTime - startTime) + " ns.");
    }

    public static void first10NumFactorialSerial() {
        for (int i=0; i<10; i++) {
            System.out.print(factorialCalc(i) + " ");
        }
        System.out.println();
    }
    public static void first10NumFactorialParallel() {
        Thread[] threads = new Thread[10];
        for (int i=0; i<10; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> System.out.print(factorialCalc(finalI) + " "));
            threads[i].start();
        }
        for (Thread thread: threads) {
            try{
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println();
    }
    public static int factorialCalc(int num) {
        if (num <=1) {
            return num;
        }
        return num * factorialCalc(num-1);
    }
}
