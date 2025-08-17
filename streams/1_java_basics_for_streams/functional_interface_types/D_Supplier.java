// package streams.functional_interface_types;

import java.util.function.Supplier;

public class D_Supplier {
    public static void main(String[] args) {
        Supplier<String> helloWorldSupplier = () -> "Hello World";
        System.out.println(helloWorldSupplier.get());
    }
}
