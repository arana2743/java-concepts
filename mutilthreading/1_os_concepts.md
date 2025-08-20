

1. CPU -> brain of computer
2. Core -> fundamental processing unit that executes instructions and perform calculations. (smallest independent brain unit within larger brain)
3. Program -> set of instructions written in programming language.
4. Process -> An instance of Program that is being executed by OS.
5. Thread -> The smallest unit of execution with Process. A Process can have multiple threads, which share the same resources but run independently.

Multitasking
-> Allows the OS to run multiple processes simultaneously.
-> On single-core CPU - this is done using time sharing, rapidly switching between tasks.
-> On multi-core CPU - true parallel execution occurs, with tasks distributed across cores. The OS Scheduler balances the load, ensuring efficient and responsive system performance.
-> when an OS performs multitasking it can assign different tasks to different cores. More efficient than assigning all tasks to single core.

Multithreading
-> Refers to the ability to execute multiple threads within a single process concurrently.
-> Multithreading enhances the efficiency of Multitasking by breaking down individual tasks into smaller sub-tasks or Threads. These threads can be processed simultaneously, making better use of CPU's capabilities.
-> In Single Core:
    - Both the threads and processes are managed by the OS scheduler through time slicing and context switching to create the illusion of simultaneous execution.
-> In Multi Core:
    - Both the threads and processes can run in true parallel on different cores, with OS scheduler distributing tasks across the cores to optimize performance.


Time Slicing:
-> Time slicing divides the CPU time into small intervals called time slices or quanta.
-> Function: The OS Scheduler allocates these time slices to different Processes and Threads, ensuring each gets a fair share of CPU time.
-> Purpose: This prevents any single process or thread from monopolizing the CPU, improving responsiveness and enabling concurrent execution.

Context Switching:
-> Context switching is the process of saving the state of currently running Process or Thread, and loading the state of next one to be executed.
-> Function: When a Process or Thread time slice expires, the OS scheduler performs a context switch to move the CPU focus to another Process or Thread.
-> Purpose: This allows multiple Process or Thread to share the CPU, giving the appearance of simultaneous execution on a single-core CPU or improving parallelism on multi-core CPU.

Multitasking vs Multithreading
-> first
    - Multitasking can be achieved through multithreading where each task is divided into Threads that are managed concurrently.
    - While Multitasking typically refers to the running of multiple applications, Multithreading is more granular dealing with multiple threads within the same application or process.
-> second
    - Multitasking operates at the level of Processes, which are OS's primary units of execution.
    - Multithreading operates at the level of Threads, which are smaller units within Process.
-> third
    - Multitasking involves managing resources between completely seprate programs, which may have independent memory spaces and system resources.
    - Multithreading involves managing resources within a single program, where threads share the same memory and resources.


Java Support for Multithreading
    - Provides robust support for Multithreading allowing developers to create applications that can perform multiple tasks simultaneously, improving peformance and responsiveness.
    - In Java, Multithreading is the concurrent execution of two or more threads to maximize the utilizationf of CPU.
    - Java's multithreading capabilities are part of the **java.lang** package, making it easy to implement concurrent execution.
    - for Single Core Environment:
        - Java's Multithreading is managed by the JVM and the OS, which switch between Threads to give the illusion of concurrency.
        - The Threads share the single core, and time-slicing is used to manage thread execution.
    - for Multi Core Environment:
        - Java's Multithreading can take full advantage of available cores.
        - The JVM can distribute threads across multiple cores, allowing true parallel execution of Threads.
    - A thread is a lightweight process, the smallest unit of processing. 
    - Java Supports multithreading through:
        - `java.lang.Thread` Class
        - `java.lang.Runnable` Interface
    - When a Java Program starts one thread begins running immediately which is called the **main** thread. This thread is responsible for executing the main method of a Program.
    - To create a Thread in Java, you can do either of below 2 options:
        - extend the `Thread` Class
        - implement the `Runnable` Interface
