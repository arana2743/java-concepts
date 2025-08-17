// package streams.functional_interface_types;

import java.util.function.Consumer;
import java.util.List;
import java.util.Arrays;

public class C_Consumer {
    public static void main(String[] args) {
        Consumer<Integer> intPrint = x -> System.out.println(x);
        intPrint.accept(20);
        intPrint.accept(100);
        
        List<Integer> arrList = Arrays.asList(1,2,3,4,5);
        Consumer<List<Integer>> listPrint = (list) -> {
            for (int x: list) {
                System.out.print(x + " ");
            }
            System.out.println();
        };

        listPrint.accept(arrList);
    }
}
