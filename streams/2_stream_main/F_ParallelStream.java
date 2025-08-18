// package stream.2_stream_main;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;


public class F_ParallelStream {
    public static void main(String[] args) {
        // task 1: calculate factorial of first 20000 numbers
        List<Integer> numList = Stream.iterate(1, x -> x + 1).limit(20000).toList();

        // with normal stream
        long start = System.currentTimeMillis();
        List<Long> factorialsList = numList.stream().map(x -> F_ParallelStream.factorial(x)).toList();
        // List<Long> factorialsList = numList.stream().map(F_ParallelStream::factorial).toList();
        long end = System.currentTimeMillis();
        System.out.println("Factorial with stream took: " + (end - start) + " ms.");
        
        // with parallel stream
        start = System.currentTimeMillis();
        List<Long> factorialListParallel = numList.parallelStream().map(F_ParallelStream::factorial).toList();
        end = System.currentTimeMillis();
        System.out.println("Factorial with parallel stream took: " + (end - start) + " ms.");

        // task 2: cumulative sum - here tasks are not independent
        // [1,2,3,4,5] -> [1,3,6,10,15]
        List<Integer> numList2 = Arrays.asList(1,2,3,4,5);
        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> cumulativeSumList = numList2.parallelStream().sequential().map(x -> sum.addAndGet(x)).toList();
        System.out.println("Parallel cumulative sum: " + cumulativeSumList);
    }

    public static long factorial(int n) {
        long factorialResult = 1;
        for (int i=2; i<=n; i++) {
            factorialResult *= i;
        }
        return factorialResult;
    }
}
