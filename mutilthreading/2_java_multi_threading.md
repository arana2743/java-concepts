# Multithreading in Java
https://www.youtube.com/watch?v=4aYvLz4E1Ts
@ 1.11.58
### Thread Creation
- To create a thread in Java, we have below two options:
    - `Thread` Class => extend this Class
    - `Runnable` Interface => implement this Interface

### Thread Lifecycle
- The lifecycle of a Thread in Java consists of several states, which a Thread can move through during its execution.
- Below are 5 states a Thread can have:
    - NEW
        - A Thread is in this state when it is created but not yet started.
    - RUNNABLE
        - After the start method is called, the Thread becomes Runnable. It's ready to run and is waiting for CPU time.
    - RUNNING
        - The Thread is in this state when it is executing.
    - BLOCKED/WAITING
        - A Thread is in this state when it is waiting for a resource or for another Thread to perform an action.
        - Also has TIMED_WAITING which is when thread is waiting for something.
    - TERMINATED
        - A Thread is in this state when it has finished executing.

### Thread methods
- Some of the most commong Thread methods are:
    - start() -> start the thread
    - run() -> override method which contains logic for thread to do.
    - sleep() -> Thread class static method which makes current scope thread to sleep.
    - join() -> allows the thread to finish before moving to next execution step.
    - setPriority()
        - allows to set priority to a Thread (ranges from 1 to 10). 
        - Also below are enums available in Thread class for priority along with priority number:
            - MAX_PRIORITY (10) => highest priority with priority number 10
            - NORM_PRIORITY (5) => (DEFAULT) medium(or normal) priority with priority number 5
            - MIN_PRIORITY (1) => lowest priority with priority number 1
    - getPriority() -> allows to fetch the Priority of given Thread.
    - interrupt() -> allows to interrupt a thread when it's waiting.
    - yield() -> allows the Thread to give up it's CPU cycle time.
    - setDaemon() 
        - Daemon Thread has the ability to run in background (unlike normal Thread or user Thread that we create).
        - JVM doesn't wait for Daemon Threads.
        - Meaning if all User Threads are completed then Main Thread will not wait for Daemon Thread to finish.

### Critical Section
- Refers to a segment of code in program where shared resources are accessed or modified by multiple threads.

### Synchronization
- Makes sure that only single Thread modifies/runs a particular code at a time.
- Helps in race-condition between threads in cases of shared resources.
- We can synchronize in below ways:
    - Entire function with `synchronized` keyword
        - e.g., 
        ``` java
        public synchronized <function-name>() { 
            <function-block>
        }
        ```
    - Particular code-block
        - e.g., below will synchronize single instance block
        ```java 
        synchronized(this) { 
            <code-block> 
        }
        ```

### Mutual Exclusion
- Mutual exclusion in Java is a synchronization mechanism that ensures only one thread can access a shared resource or a critical section of code at any given time.
- This prevents race conditions and data corruption that can occur when multiple threads attempt to modify the same data concurrently.

### Locks
- Two types of locks:
    1. Intrinsic
        - These are built into every object in Java.
        - We don't actually see them, but they're there.
        - When we use a `synchronized` keyword, behind the scenes these automatic locks are being used.
    2. Explicit
        - These are more advanced locks which we can control.
        - We can explicitly control when to lock and unlock, giving more control of how and when to access/modify a resource.
        - `java.util.concurrent.locks.` is used to control explicit locks.

### Explicit Lock implementation
- we implement explicit lock using `Lock` Interface.
    - e.g.,
    ``` java
    final Lock lock = new ReentrantLock();
    ```
- some methods available with Lock interface:
    - lock() 
        - indefinite lock until unlock() (also allows to achive similar effect to synchronized)
        - this lock cannot be interrupted
    - tryLock() 
    - lockInterruptibly()
        - this lock can be interrupted
    - unlock()

### Reentrant Lock in Java
- A Reentrant lock is a Java concurrency utility that allows the thread to acquire the same lock multiple times without blocking itself, unlike traditional `synchronized` blocks where a Thread can only hold a Lock once.
- It Implements the `Lock` interface, providing more flexibility than `synchronized`, by enabling features like: 
    - interruptible lock acquisition,
    - fairness options,
    - condition objects for thread signaling
- A `hold count` tracks the number of times a thread acquired the lock, and it is only fully released when this count reaches zero.

### Fairness of Locks
- In Java concurrency utilities, specifically with `ReentrantLock`: 
    - Fairness of locks refers to policy by which waiting threads acquire lock.
- Fair Lock:
    - A fair lock ensures that threads acquire the lock in the order they requested it, following a First-in, First-out (FIFO) principle.
    - This means the thread that has been waiting the longest will be granted the lock next, preventing "**starvation**" - where a thread might repeatedly lose out on acquiring the lock to other, newer threads.
    - Fairness is typically achieved by maintaining a queue of waiting threads and granting the lock to the head of the queue.
- UnFair Lock:
    - This is the default behaviour of `ReentrantLock` if not specified, does not guarantee any particular order of lock acquisition among waiting threads.
    - A newnly arrived thread might "jump the queue" and acquire the lock before the thread that has been waiting longer.
    - Unfair locks offer better performance than fair locks because they involve less overhead in maintaining the order of waiting threads.
- Unfair VS Fair Locks:
    - Peformance:
        - Fair locks can introduce performance overheads due to the need to maintain and manage the waiting queue.
    - Starvation:
        - Fair locks can prevent starvation, ensuring all waiting threads get a chance to execute.

### Disadvantages of Synchronized (Intinsic locks)
- Fairness
- Blocking (Deadlocks can occur)
- Interruptibility
- Read/Write Locking (synchronized doesn't know which is read-lock and which is write-lock)

### ReadWrite Lock
- Allows multiple threads to read concurrently of resources as long as no thread is writing to the same resources.
- It ensures exclusive acccess for write operations.

### Deadlocks
- Deadlock is a situation in multithreading where two or more threads are blocked forever, waiting for each other to release a resource.
- This typically occurs when two or more threads have a circular dependencies on a set of locks.
- Deadlock typically occurs when four conditions are met simultaneously:
    - Mutual Exclusion:
        - Only one thread can access a resource at a time.
    - Hold and Wait:
        - A thread holding at least one resource is waiting to acquire additional resources held by other threads.
    - No Preemption:
        - Resources cannot be forcibly taken from threads holding them.
    - Circular Wait:
        - A set of threads waiting for each other in a circular chain.

### Thread Communication
- In a multithreaded environment, threads often need to communicate and coordinate with each other to accomplish a task.
- And without proper communication mechanisms, threads might end up in inefficient busy-waiting states, leading to wastage of CPU resources and potential deadlocks.
- methods used in java for inter-thread communication:
    - wait() => notifies currentThread to release lock and wait until another thread calls notify or notifyAll.
    - notify() => wakes up a single thread that is waiting.
    - notifyAll() => wakes up all threads that are waiting.
- above methods can only be called in a **synchronized context**.

### Thread Safety
- Thread Safe
    - An object or method or code-block is thread-safe when:
        - it guarantees that un-expected result will never occur nor will there by any race-condition when multiple threads are trying to access it.

### Threads with lambda expressions
- Threads can also be used with help of lambda expressions to reduce boilerplate code.
- we can use lambda expression to override run method of Runnable interface(since it's a functional interface).


### Thread Pool
- Thread pooling is collection of pre-initialized threads that are ready to perform a task.
- Why?
    - Resource management
        - creating and destroying a thread each time for a task can be expensive.
    - Response time
        - gives better response time for each task since threads are already pre-initialized.
    - Control over thread count
        - allows to limit the number of threads that can run at a time for better memory and resource managment.
- In Java, thread pool is creatd using **Executors Framework**.
- About Executors Framework
    - part of `java.util.concurrent` package.
    - simplify the development of concurrent applications by abstracting away many of the complexities involved in creating and managing threads.
    - below are extra handling that Executors Framework provides:
        - Manual Thread Managment
        - Resource Management
        - Scalability 
        - Thread Reuse
        - Error Handling
- Executor framework implementation
    - has 3 core interfaces:
        - Executor
        - ExecutorService
        - ScheduledExecutorService
- ExecutorService some methods:
    - submit(Runnable task)
    - submit (Callable task)
    - submit(Runnable r, T result)
    - shutdown()
    - shutdownNow()
    - awaitTermination()
    - isShutdown()
    - isTerminated()
    - invokeAll()
        - takes collection of callables and executes them and waits for their completion.
        - stores the result in list of Futures
    - invokeAny()
        - takes collection of callables and executes them and waits for any one of task to complete
        - it only returns the result of any 1 task that completes first.
- Future some methods:
    - get()
    - isDone()
    - isCancelled()
    - get(time)
    - cancel() ==> to cancel a task
- ScheduledExecutorService some methods:
    - schedule(Runnable task)
    - schedule(Callable task)
    - scheduleAtFixedRate(Runnable task, initialDelay, period, TimeUnit)
    - scheduleWithFixedDelay(Runnable task, initialDelay, delay, TimeUnit)
- Types of thread pool that can be created:
    - Threadpool is created with built in **Executors** class in concurrent package
    - used below implementations:
        - newFixedThreadPool(corePoolSize) => created thread pool of passed size.
        - newSingleThreadExecutor() => creates a single thread pool
        - newScheduledThreadPool(corePoolSize) => creates a scheduled thread pool of passed size.
        - newCachedThreadPool() => creates a thread pool that creats threads as per needed and terminates threads after a certain timeout (60 seconds) when not in use.

### CountDownLatch
- So Executor framework in Java doesn't have any method which will allow the main thread to wait for all executors to complete
- CountDownLatch helps to solve this problem.
- **Note**: Once the countDownLatch count reaches zero it cannot be reset. Therefore same countDownLatch object cannot be used again.

### CyclicBarrier
- Unlike CountDownLatch, CyclicBarrier can be reused. Once all threads have reached the barrier and are released, the barrier resets, allowing for subsequent synchronization points in a multi-stage process.
- CyclicBarrier in Java is a synchronization aid that allows a set of threads to wait for each other to reach a common barrier point before proceeding.


### CompletableFuture
- is used to handle asynchronous programming or non-blocking program execution.
- available in `java.util.concurrent` package
- some method:
    - CompletableFuture.supplyAsync(Supplier supplier)
    - CompletableFuture.get() -> allows to wait for the thread
    - CompletableFuture.getNow(valueIfAbsent) -> returns result if completed otherwise return valueIfAbsent
    - CompletableFuture.allOf(future1, future2) -> will combine result (completion status and not exact result of futures) of future1 and future2
    - join() -> will wait on future completion
- By default, CompletableFuture tasks often run on Daemon threads due to use of `ForkJoinPool.commonPool`
- You can control the thread type by providing the custom executor service.
- The CompletableFuture task itself doesn't dictate whether it's a Daemon thread or User thread.