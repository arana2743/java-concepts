// package stream.2_stream_main;

import java.util.stream.Stream;
import java.util.List;
import java.util.Arrays;

public class B_StreamCreation {
    public static void main(String[] args) {
        // different ways to create a stream
        // 1. from Java collections
        List<Integer> numList = Arrays.asList(1,2,3,4,5);
        Stream<Integer> numListStream = numList.stream();
        
        // 2. from primitive arrays
        String[] studentNames = {"John", "Doe", "Jaine", "Jamey"};
        Stream<String> studentNamesStream = Arrays.stream(studentNames);

        // 3. from Stream.of() method
        Stream<String> alphabetStream = Stream.of("a", "b", "c");

        // 4. infinite stream
        // 4.1 Stream.generate()
        Stream<Integer> infiniteGenStream = Stream.generate(() -> 1);

        // 4.2 Stream.iterate() -> used when need to create a sequence with starting value
        Stream<Integer> infiniteIterStream = Stream.iterate(1, x -> x + 1);
    }
}
