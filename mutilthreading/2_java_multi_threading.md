# Multithreading in Java

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
            