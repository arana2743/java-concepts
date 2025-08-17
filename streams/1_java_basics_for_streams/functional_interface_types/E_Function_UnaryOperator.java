// package streams.functional_interface_types;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class E_Function_UnaryOperator {
    public static void main(String[] args) {
        Function<Integer, Integer> squareInt = (x) -> x * x ;
        System.out.println("Square of 4 is " + squareInt.apply(4));

        // with UnaryOperator
        UnaryOperator<Integer> squaredNum = x -> x * x;
        System.out.println("Square of 5 is " + squaredNum.apply(5));
    }
}
