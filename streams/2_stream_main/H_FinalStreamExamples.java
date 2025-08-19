// package stream.2_stream_main;

import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.Optional;

public class H_FinalStreamExamples {
    public static void main(String[] args) {
        // 1. Collecting names by length
        List<String> namesList1 = Arrays.asList("Alexander", "Bruce", "Johnny", "Stewie", "Brice", "Peter");
        Map<Integer, List<String>> namesByLength1 = namesList1.stream()
            .collect(Collectors.groupingBy(String::length));
        System.out.println("Collecting of names by length: " + namesByLength1);

        // 2. Counting word occurrences
        String sentenceStr1 = "hello world hello world java programming";
        Map<String, Long> wordCountMap = Arrays.stream(sentenceStr1.split(" "))
            .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println("Word count: " + wordCountMap);

        // 3. Partitioning even and odd numbers
        List<Integer> numFirst10 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Map<Boolean, List<Integer>> evenOddPartition = numFirst10.stream()
            .collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println("Even odd partition: " + evenOddPartition);

        // 4. Summing values in a Map
        Map<String, Integer> fruitStockMap = new HashMap<>();
        fruitStockMap.put("Apple", 10);
        fruitStockMap.put("Banana", 20);
        fruitStockMap.put("Orange", 15);
        long sumFruitValues = fruitStockMap.values()
            .stream()
            .collect(Collectors.summingInt(x -> x));
        System.out.println("Sum of total fruit stock: " + sumFruitValues);
        // can also use reduce
        Optional<Integer> sumFruitValuesReduce = fruitStockMap.values()
            .stream()
            .reduce((x,y) -> x + y);
        System.out.println("Sum of total fruit stock using reduce: " + sumFruitValuesReduce.get());

        // 5. Creating a map from stream elements
        List<String> fruits1 = Arrays.asList("Apple", "Banana", "Cherry", "Kiwi");
        Map<Object, Object> fruitsLenghtMap = fruits1.stream()
            .collect(Collectors.toMap(x -> x.toUpperCase(), x -> x.length()));
        System.out.println("fruits with length map: " + fruitsLenghtMap);

        // 6. count words using toMap() having merge() signature
        List<String> words2 = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Integer> wordsCountMap2 = words2.stream()
            .collect(Collectors.toMap(k -> k, v -> 1, (x,y) -> x + y));
        System.out.println("words count using toMap with merge: " + wordsCountMap2);
    }
}
