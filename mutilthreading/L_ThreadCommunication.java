public class L_ThreadCommunication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        
        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));

        producerThread.start();
        consumerThread.start();
    }
}

class Producer implements Runnable {
    private SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }
    @Override
    public void run() {
        for (int i=1; i<11; i++) {
            this.sharedResource.produce(i);
        }
    }
}

class Consumer implements Runnable {
    private SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i=1; i<11; i++) {
            this.sharedResource.consume();
        }
    }
}
class SharedResource {
    private int data;
    private boolean hasData;

    public synchronized void produce(int data) {
        while(hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
                Thread.currentThread().interrupt();
            }
        }
        this.data = data;
        this.hasData = true;
        System.out.println("Produced data: " + data);
        notify();
    }

    public synchronized int consume() {
        while(!hasData) {
            try{
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
                Thread.currentThread().interrupt();
            }
        }
        this.hasData = false;
        System.out.println("Consumed data: " + this.data);
        notify();
        return this.data;
    }
}