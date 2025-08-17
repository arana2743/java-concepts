// package streams.functional_interface_types;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class F_Function_BinaryOperator {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> squareIntSum = (x, y) -> x * x + y * y;
        System.out.println("Squared sum of 3 and 4 is: " + squareIntSum.apply(3, 4));

        // now with BinaryOperator
        BinaryOperator<Integer> squareNumSum = (x, y) -> x * x + y * y;
        System.out.println("Squared sum of 3 and 4 is: " + squareNumSum.apply(3, 4));
    }   
}
