package java_basics_for_streams;
// package streams;

public class B_RealWorldExWithoutLambda {
    public static void main(String[] args) {
        // using the custom classes 
        int a = 20, b = 30;
        System.out.println("a=" + a + ", b=" + b);
        
        MathOperation addNums = new SumOperation();
        int addResult = addNums.operate(a, b);
        System.out.println("Sum result: " + addResult);

        MathOperation subNums = new SubOperation();
        int subResult = subNums.operate(a, b);
        System.out.println("Diff result: " + subResult);
    }
}

// class implementing functional interface
class SumOperation implements MathOperation {
    @Override
    public int operate(int a, int b) {
        return a + b;
    }
}

class SubOperation implements MathOperation {
    @Override
    public int operate(int a, int b) {
        return a - b;
    }
}
// functional interface
interface MathOperation {
    int operate(int a, int b); 
}