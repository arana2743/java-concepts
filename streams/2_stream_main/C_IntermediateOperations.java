// package 2_stream_main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class C_IntermediateOperations {
    public static void main(String[] args) {
        List<String> namesList = Arrays.asList("John", "Tom", "Brad", "Liam", "Donny");

        // 1. filter()
        Stream<String> filterNamesStream = namesList.stream().filter(x -> x.startsWith("J"));

        // 2. map()
        // e.g., convert all names to uppercase
        Stream<String> mapUpperCaseNamesStream = namesList.stream().map(x -> x.toUpperCase());
        // with method reference
        Stream<String> mapUpperCaseNamesStream2 = namesList.stream().map(String::toUpperCase);

        // 3. sorted()
        // e.g., sort the names 
        Stream<String> sortedNamesStream = namesList.stream().sorted();
        Stream<String> sortedNamesByLengthStream = namesList.stream().sorted((a,b) -> a.length() - b.length());

        // 4. distinct()
        List<Integer> numsList = Arrays.asList(1,1,2,3,4,5,5,5,6,6,6,6,7);
        Stream<Integer> uniqueEvenNumsStream = numsList.stream().filter(x -> x %2 ==0).distinct();

        // 5. limit()
        Stream<Integer> infiniteStream = Stream.iterate(1, x -> x +1);
        Stream<Integer> first100NumsStream = Stream.iterate(1, x -> x + 1).limit(100);

        // 6. skip
        Stream<Integer> skipFirst10NumsStream = Stream.iterate(1, x -> x + 1).skip(10).limit(100);
    }
}
