package java_basics_for_streams;
// package streams;

import java.util.List;
import java.util.Arrays;

public class C_MethodReference {
    public static void main(String[] args) {
        List<Integer> arrList = Arrays.asList(1,2,3,4,5);

        // with lambda expressions
        arrList.forEach(x -> System.out.print(x + " "));
        System.out.println();

        // with method reference
        arrList.forEach(System.out::print);
        System.out.println();
    }
}
