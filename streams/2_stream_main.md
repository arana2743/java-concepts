# Stream Main

### Stream
    - Stream is a feature introduced in Java 8.
    - A stream is sequence of elements supporting functional and declarative programming.
    - Used to process Java-Collections of data in a functional and declarative manner.
    - few advantages of using stream
        - Embrace functional programming
        - Simplify data processing
        - Improve readability and maintainability
        - Enable easy parallelism (by achieving parallelism without dealing with complexity of `Threads`)

### How to use stream?
1. Data Source
2. Intermediate Operations
    - Intermediate operations transform a steam into another stream.
    - They are lazy, meaning they don't execute until a terminal operation is invoked.
    - Common intermediate operations are:
        - filter()
        - map()
        - sorted()
        - distinct()
        - limit()
        - skip()
        - peek()
            - **similar to forEach: performs an action on each element as it flows through the stream pipeline without modifying the elements themselves.**
            - **useful for debugging flow at any step in stream pipeline.**
        - flatMap()
            - Handles stream of collections, lists, or arrays where each element is itself a collection, list or arrays
            - it flattens the nested structure (e.g, list of lists) so that they can be processed as single sequence of elements.
            - So overall it transforms and flatten elements at the same time.
3. Terminal Operation
    - Common terminal operations are:
        - collect()
        - forEach()
        - forEachOrdered
            - useful in parallel stream when we want to process the elements in their original order (since in parallel stream there is no order)
        - reduce()
        - count()
        - anyMatch(), allMatch(), noneMatch()
        - findFirst(), findAny()
        - toArray()
        - min(), max()

### Stateful and Stateless Stream Operations
1. Stateless Operations
    - These operations process each element independently without requiring any knowledge of other elements in the stream or maintaining internal state across elements.
    - Characterstics:
        - They are highly efficient, especially in parallel streams, as each element can be processed in isolation without needing to synchronize or buffer data.
        - They do not require multiple pass over the data.
    - e.g., filter(), map(), forEach()
2. Stateful Operations
    - These operations require retaining information about previously processed elements or the entire stream to produce a result for the current element.
    - They maintain an internal state that changes as elements are processed.
    - Characterstics:
        - They can be less efficient in parallel streams, as they may require buffering data or multiple passes to ensure correct results.
        - They might need to process the entire input before producing any result.
    - e.g., distinct(), sorted(), reduce(), limit(), skip()

### How to create a stream?
1. From Java Collections
    - e.g.,
    ``` java
    List<Integer> arrList = Arrays.asList(1,2,3,4,5);
    Stream<Integer> stream = arrList.stream();
    ```
2. From Arrays
    - e.g.,
    ``` java
    String[] arr = {"a","b","c"};
    Stream<String> stream = Arrays.stream(arr);
    ```
3. Using Stream.of() method
    - e.g.,
    ``` java
    Stream<String> stream = Stream.of("a","b","c");
    ```
4. Infinite streams
    - e.g.,
    ``` java
    Stream<Integer> streamGen = Stream.generate(() -> 1);
    Stream<Integer> streamGenLimit = Stream.generate(() -> 1).limit(10);
    ```
    - e.g.,
    ``` java
    Stream<Integer> streamIterate = Stream.iterate(0, x -> x + 1);
    Stream<Integer> streamIterateLimit = Stream.iterate(0, x -> x + 1).limit(10);
    ```

### Parallel Stream
    - A type of stream that enables parallel processing of elements
    - Allowing multiple threads to process parts of the stream simulataneously.
    - This can significantly improve performance for large datasets.
    - Characterstics:
        - Most effective for CPU-intensive or for large datasets where tasks are independent.
        - May add overhead for simple tasks or small datasets.

**IMPORTANT NOTE: Stream cannot be used after a termninal operation has been performed.**

### Collectors
    - Collectors is a utility class in Stream.
    - Provides a set of methods to create commong collectors.
    - Some Collectors utility methods are:
        - toList() -> Collecting to a list.
        - toSet() -> Collecting to a set.
        - toCollection() -> Collecting to a specified Collection
        - joining() -> Collecting to join into a single string
        - summarizingInt(), summarizingDouble(), summarizingLong()
            - Collecting to summarize data
            - basically generating statistical data (count, sum, average, min, max)
        - averagingInt() -> Collecting to the average of stream
        - counting() -> Collecting to count of elements of stream
        - summingInt() -> Collecting to sum of stream
        - groupingBy() -> Collecting to grouped elements
        - partitioningBy() -> Collecting to two partitions (true or false) based on predicate
        - mapping() -> Mapping and Collecting (applies a mapping function before collecting)
        - toMap() -> Collecting to a map with key,value
            - has also a signature with `merge` which allows some processing for merging two same keys

### Primitive Stream
    - Primitive steams are relevant for creating streams from primtive datatypes.
