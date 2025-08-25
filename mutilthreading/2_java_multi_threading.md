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