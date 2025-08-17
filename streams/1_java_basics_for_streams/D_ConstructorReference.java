package java_basics_for_streams;
// package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class D_ConstructorReference {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Samsung", "Apple", "Xiomi", "Nokia");

        // with lambda expressions 
        List<Mobile> mobileNames = names.stream().map(x -> new Mobile(x)).collect(Collectors.toList());
        
        // with constructor reference
        List<Mobile> mobileNames2 = names.stream().map(Mobile::new).collect(Collectors.toList());

        mobileNames.forEach(System.out::println);
        mobileNames2.forEach(System.out::println);
    }
}

class Mobile {
    String name;

    Mobile(String name) {
        this.name = name;
    }

    public String toString() {
        return "Mobile(name='" + this.name + "')";
    }
}