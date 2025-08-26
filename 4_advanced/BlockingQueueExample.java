import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * This class demonstrates the Producer-Consumer problem using a BlockingQueue.
 * This is a classic example of using concurrent collections for thread-safe communication.
 */
public class BlockingQueueExample {

    public static void main(String[] args) {
        // A shared queue that can hold up to 10 elements.
        // 10 elements ni hold cheyagalige oka shared queue.
        BlockingQueue<Integer> sharedQueue = new ArrayBlockingQueue<>(10);

        // Create and start the producer thread
        Thread producerThread = new Thread(new Producer(sharedQueue));
        producerThread.start();

        // Create and start the consumer thread
        Thread consumerThread = new Thread(new Consumer(sharedQueue));
        consumerThread.start();
    }
}

// The Producer class
class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println("Producing: " + i);
                queue.put(i); // Puts an element, waits if the queue is full.
                Thread.sleep(50); // Simulate some work
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// The Consumer class
class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer value = queue.take(); // Takes an element, waits if the queue is empty.
                System.out.println("Consuming: " + value);
                Thread.sleep(100); // Simulate some work
                if (value == 99) { // A condition to stop the consumer
                    break;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
