// package stream.2_stream_main;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Optional;

public class E_StreamExample1 {
    public static void main(String[] args) {
        List<String> namesList = Arrays.asList("Anna", "David", "Bob", "John", "James");
        List<Integer> numList = Arrays.asList(5,2,9,1,6,3,8,4,7);

        // task 1: get all names with length > 4
        List<String> namesLenGtThan4 = namesList.stream().filter(x -> x.length() > 4).toList();
        System.out.println("Names with length greater than 4: " + namesLenGtThan4);

        // task 2: square the number and then sort them in increasing order
        List<Integer> numSquaredSorted = numList.stream().map(x -> x * x).sorted().toList();
        System.out.println("Nums squared and sorted(asc): " + numSquaredSorted);

        // task 3: sum of first 50 natural numbers
        Optional<Integer> first50Sum = Stream.iterate(1, x -> x + 1).limit(50).reduce(Integer::sum);
        System.out.println("Sum of first 50 natural numbers: " + first50Sum.get());

        // task 4: counting occurrence of a character
        // count occurrence of character 'l' in "Hello World"
        String helloWorldStr = "Hello World";
        int lCount = (int) helloWorldStr.chars().filter(x -> x == 'l' || x == 'L').count();
        System.out.println("Count of character 'l' in 'Hello World': " + lCount);
        
    }
}
