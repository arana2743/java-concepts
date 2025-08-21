# Multithreading in Java
https://www.youtube.com/watch?v=4aYvLz4E1Ts
@ 47.55
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