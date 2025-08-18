// package stream.2_stream_main;

import java.util.Arrays;
import java.util.List;

class A_Example {
    public static void main(String[] args) {
        List<Integer> arrList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // find even numbers count using stream
        int evenCount = (int)arrList.stream().filter(x -> x % 2 ==0).count();
        System.out.println("even count: " + evenCount);
    }
}
