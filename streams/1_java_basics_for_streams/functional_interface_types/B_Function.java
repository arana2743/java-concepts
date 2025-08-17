// package streams.functional_interface_types;

import java.util.function.Function;

public class B_Function {
    public static void main(String[] args) {
        Function<Integer, Integer> doubleIt = x -> 2 * x;
        System.out.println("Double of 10 is: " + doubleIt.apply(10));
        
        Function<Integer, Integer> tripleIt = x -> 3 * x;
        System.out.println("Triple of 99 is: " + tripleIt.apply(99));

        // combine two Function using andThen()
        int doubleTripleResult = doubleIt.andThen(tripleIt).apply(15);
        System.out.println("Doubling then tripling 15 is: " + doubleTripleResult);

        // combine two Function using compose()
        // which applies second Function first and then first Function
        int tripleDoubleResult = doubleIt.compose(tripleIt).apply(6);
        System.out.println("Tripling then doubling 6 is: " + tripleDoubleResult);

        // Static method: indentity()
        Function<Integer, Integer> indentityFunction = Function.identity();
        System.out.println("Passing 5 to identity: " + indentityFunction.apply(5));
    }
}
