// package stream.2_stream_main;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.Comparator;

public class D_TerminalOperations {
    public static void main(String[] args) {
        List<Integer> arrList = Arrays.asList(1,2,3,4,5);

        // 1. collect()
        arrList.stream().skip(1).collect(Collectors.toList());
        // we can do shorthand in newer java version as well
        arrList.stream().skip(1).toList();

        // 2. forEach()
        arrList.stream().skip(1).forEach(System.out::print);
        System.out.println();

        // 3. reduce()
        Optional<Integer> sumResult = arrList.stream().reduce((x,y) -> x + y);
        // can be converted to method reference as well
        Optional<Integer> sumResult2 = arrList.stream().reduce(Integer::sum);
        System.out.println("Sum : " + sumResult.get());
        System.out.println("Sum : " + sumResult2.get());

        // 4. count()
        int elemCount = (int) arrList.stream().count();
        System.out.println("Elements count: " + elemCount);

        // 5. anyMatch(), allMatch(), noneMatch()
        // anyMatch() - true when any of element matches the predicate
        boolean anyEvenNum = arrList.stream().anyMatch(x -> x % 2 == 0);
        System.out.println("Is there any even number in list? : " + anyEvenNum);
        
        // allMatch() - true only when all elements matches the predicate
        boolean allGreaterThanZero = arrList.stream().allMatch(x -> x > 0);
        System.out.println("All elements greater than zero in list? : " + allGreaterThanZero);

        // noneMatch() - true only when none of the elements matches the predicate
        boolean noneLessThanZero = arrList.stream().noneMatch(x -> x < 0);
        System.out.println("No matches of elements less than zero in list? : " + noneLessThanZero);

        // 6. findFirst(), findAny()
        Optional<Integer> firstMatch = arrList.stream().skip(2).findFirst();
        System.out.println("first match element: " + firstMatch.get());

        Optional<Integer> anyMatch = arrList.stream().skip(-0).findAny();
        System.out.println("any match element: " + anyMatch.get());

        // 7. toArray()
        Object[] intArrFromStream = Stream.of(1,2,3,4,5).toArray();

        // 8. min(), max()
        Optional<Integer> minFromIntStream = Stream.of(1,2,100,205,-99).min(Comparator.naturalOrder());
        Optional<Integer> maxFromIntStream = Stream.of(1,2,100,205,-99).max(Comparator.naturalOrder());
        System.out.println("min value: " + minFromIntStream.get());
        System.out.println("max value: " + maxFromIntStream.get());

        // 9. forEachOrdered
        List<Integer> first10NaturalNumsList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("Using forEach() with parallelStream");
        first10NaturalNumsList.parallelStream().forEach(System.out::print);
        System.out.println();
        System.out.println("Using forEachOrdered with parallelStream");
        first10NaturalNumsList.parallelStream().forEachOrdered(System.out::print);
        System.out.println();

    }
}
