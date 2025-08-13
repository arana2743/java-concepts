// package streams;

public class A_ThreadWithoutLambda {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ExecuteTask());
        t1.start();
    }
}

class ExecuteTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Running the task.");
    }
}