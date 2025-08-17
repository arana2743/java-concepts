package java_basics_for_streams;
// package streams;

public class B_RealWorldExWithLambda {
    public static void main(String[] args) {
        int a = 20, b = 30;
        System.out.println("a=" + a + ", b=" + b);

        MathOperation addNums = (x, y) -> x + y;
        int addResult = addNums.operate(a, b);
        System.out.println("Sum result: " + addResult);

        MathOperation subNums = (x, y) -> {
            return x - y;
        };
        int subResult = subNums.operate(a, b);
        System.out.println("Sub result: " + subResult);
    }
}

// functional interface
interface MathOperation {
    int operate(int a, int b);
}