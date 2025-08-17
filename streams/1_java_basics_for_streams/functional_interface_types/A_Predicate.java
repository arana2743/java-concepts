// package streams.functional_interface_types;

import java.util.function.Predicate;

public class A_Predicate {
    public static void main(String[] args) {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println("Is 10 even? " + isEven.test(10));

        Predicate<String> startsWithA = x -> x.toLowerCase().startsWith("a");
        System.out.println("Does 'America' starts with 'a'? " + startsWithA.test("America"));

        Predicate<String> endsWithA = x -> x.toLowerCase().endsWith("a");
        System.out.println("Does 'America' end with 'a'? " + endsWithA.test("America"));

        // now we can also combine two predicates
        Predicate<String> startsAndEndWithA = startsWithA.and(endsWithA);
        System.out.println("Does 'Agra' starts and ends with 'a'? " + startsAndEndWithA.test("Agra"));
    }
}
