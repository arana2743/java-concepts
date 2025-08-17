package java_basics_for_streams;
public class A_ThreadWithLambda {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Running the task");
        });

        t1.start();
    }
}
