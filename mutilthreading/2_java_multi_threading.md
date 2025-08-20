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
        - TERMINATED
            - A Thread is in this state when it has finished executing.