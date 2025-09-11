public class M_ThreadsWithLambda {
    public static void main(String[] args) {
        // without lambda expressions
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("running Task 1 ");
            }
        };

        // with lambda expressions
        Runnable task2 = () -> System.out.println("running Task 2 with lambda!");

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();
    }
}
