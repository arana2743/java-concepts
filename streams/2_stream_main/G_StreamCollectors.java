// package stream.2_stream_main;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Set;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class G_StreamCollectors {
    public static void main(String[] args) {
        // 1. toList()
        List<String> namesList = Arrays.asList("Alice", "Bob", "James");
        List<String> filteredNamesList = namesList.stream()
            .filter(x -> x.startsWith("A"))
            .collect(Collectors.toList());
        System.out.println("Filtered(Starts with 'A') names: " + filteredNamesList);
        
        // 2. toSet()
        List<Integer> numsDupList = Arrays.asList(1,1,1,2,2,3,4,5,5,5,5,6);
        Set<Integer> numsDupFilteredSet = numsDupList.stream().collect(Collectors.toSet());
        System.out.println("Without duplicate set: " + numsDupFilteredSet);

        // 3. toCollection()
        LinkedList<String> namesLinkedList = namesList.stream()
            .collect(Collectors.toCollection(() -> new LinkedList<>()));
        System.out.println("Last element of linked list: " + namesLinkedList.getLast());
        System.out.println("toCollection() to linked list: " + namesLinkedList);

        // 4. joining()
        String concatenatedNames = namesList.stream()
            .map(String::toUpperCase)
            .collect(Collectors.joining("::"));
        System.out.println("Concatenated names: " + concatenatedNames);

        // 5. summarizingInt()
        List<Integer> dataList = Arrays.asList(2,3,5,7,11);
        IntSummaryStatistics dataSummary = dataList.stream()
            .collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count: " + dataSummary.getCount());
        System.out.println("Sum: " + dataSummary.getSum());
        System.out.println("Average: " + dataSummary.getAverage());
        System.out.println("Min: " + dataSummary.getMin());
        System.out.println("Max: " + dataSummary.getMax());

        // 6. averagingDouble()
        Double dataAverage = dataList.stream()
            .collect(Collectors.averagingDouble(x -> x));
        System.out.println("Averge: " + dataAverage);

        // 7. counting()
        long dataCount = dataList.stream()
            .collect(Collectors.counting());
        System.out.println("Count of elements: " + dataCount);

        // 8. summingInt()
        long dataSum = dataList.stream()
            .collect(Collectors.summingInt(x -> x));
        System.out.println("Data sum: " + dataSum);

        // 9. groupingBy()
        List<String> wordsList = Arrays.asList("hello", "world", "java", "streams", "collecting");
        // first signature - (Function)
        Map<Integer, List<String>> wordsGroupedByLength = wordsList.stream()
            .collect(Collectors.groupingBy(x -> x.length()));
        System.out.println("With signature of only Function: " + wordsGroupedByLength);
        // second signature - (Function, Collector)
        Map<Integer, String> wordsGroupedByLenAndJoined = wordsList.stream()
            .collect(Collectors.groupingBy(String::length, Collectors.joining("::")));
        System.out.println("With signature of Function,Collector: " + wordsGroupedByLenAndJoined);
        // third signature - (Function, Supplier, Collector)
        Map<Integer, String> wordsGroupedByLenAndJoinedHashMap = wordsList.stream()
            .collect(Collectors.groupingBy(String::length, HashMap::new, Collectors.joining("|")));
        System.out.println("With signature of Function,Supplier,Collector: " + wordsGroupedByLenAndJoinedHashMap);

        // 10. partitioningBy() - partitioning elements
        // partition elements into two groups (true or false) based on predicate
        Map<Boolean, List<String>> trueFalsePartitionOnLenGt5 = wordsList.stream()
            .collect(Collectors.partitioningBy(x -> x.length() > 5));
        System.out.println("Partitioning by length greater than 5: " + trueFalsePartitionOnLenGt5);
        
        // 11. mapping() - Mapping and Collecting
        // applies a mapping function before collecting
        List<String> upperCaseMappedCollectedList = wordsList.stream()
            .collect(Collectors.mapping(String::toUpperCase, Collectors.toList()));
        System.out.println("Mapping and collecting: " + upperCaseMappedCollectedList);

        // 12. toMap() 
        // with just key and value signature
        List<String> countryNames = Arrays.asList("Russia", "Spain", "Germany", "Australia");
        Map<Object, Object> countryLengthMap = countryNames.stream()
            .collect(Collectors.toMap(x -> x.toUpperCase(), x -> x.length()));
        System.out.println("To map(): " + countryLengthMap);
        // with key,value and merge signature
        List<Integer> diceRollList = Arrays.asList(1,1,1,1,2,2,2,3,4,5,6,6,6,6,6,6,6,6,6,6,6,6,4);
        Map<Integer, Integer> diceRollCountMap = diceRollList.stream()
            .collect(Collectors.toMap(k -> k, v -> 1, (x,y) -> x + y));
        System.out.println("Dice roll count using toMap with merge signature: " + diceRollCountMap);
    }
}
