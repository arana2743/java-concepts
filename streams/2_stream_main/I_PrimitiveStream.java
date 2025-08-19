// package stream.2_stream_main;

import java.util.List;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.DoubleStream;
import java.util.stream.Collectors;
import java.util.Random;
import java.util.IntSummaryStatistics;

public class I_PrimitiveStream {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};

        // create a stream of primtive type array
        IntStream numIntStream = Arrays.stream(nums);
        List<Integer> numList1 = numIntStream.filter(x -> x %2 == 0)
            .boxed()
            .collect(Collectors.toList());
        System.out.println("from primtive to wrapper: " + numList1);

        // we can create ranged values as well
        // IntStream.range() process in range with start inclusive and end exclusive
        List<Integer> first9ValuesRange = IntStream.range(1,10)
            .boxed()
            .toList();
        // IntStream.rangeClosed()
        List<Integer> first10ValuesRange = IntStream.rangeClosed(1,10)
            .boxed()
            .toList();
        System.out.println("with range() values are : " + first9ValuesRange);
        System.out.println("with rangeClosed() values are : " + first10ValuesRange);

        // IntStream.of() -> for stream creation like Stream.of()
        List<Integer> first5Values = IntStream.of(1,2,3,4,5).boxed().toList();
        System.out.println("IntStream.of() method first 5 values: " + first5Values);

        // using the help of Random class we can create primitive stream of random values as well
        DoubleStream randomDoubleStream = new Random().doubles(3);
        System.out.println("Random double values stream output");
        randomDoubleStream.forEach(System.out::println);

        // we can also summarize the primitive stream as well
        IntStream randomIntStream = new Random().ints(10);
        System.out.println("Random int values from stream output");
        IntSummaryStatistics intStreamStatistics = randomIntStream
            .peek(System.out::println)
            .summaryStatistics();
        System.out.println("Average: " + intStreamStatistics.getAverage());
        System.out.println("Count: " + intStreamStatistics.getCount());
        System.out.println("Sum: " + intStreamStatistics.getSum());
        System.out.println("Max: " + intStreamStatistics.getMax());
        System.out.println("Min: " + intStreamStatistics.getMin());

        // mapToInt()
        DoubleStream randomDoubleStream2 = new Random().doubles(5);
        List<Integer> doubleMappedToInt = randomDoubleStream2
            .peek(System.out::println)
            .mapToInt(x -> (int) (x*10 + 1))
            .boxed().toList();
        System.out.println("double mapping to int: " + doubleMappedToInt);
        
    }
}
