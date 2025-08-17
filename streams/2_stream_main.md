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
3. Terminal Operation

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