package project_brief.testing;

import project_brief.library.LinkedQueueADT;

public class QueueTest {
    public static void main(String[] args) {
        LinkedQueueADT<String> queue = new LinkedQueueADT<>();

        System.out.println("--- Starting LinkedQueueADT Testing ---");

        // 1. Test isEmpty() on new queue
        System.out.println("Is queue empty? " + queue.isEmpty()); // Expected: true

        // 2. Test offer() (Enqueue)
        System.out.println("\n[Test: Offering elements]");
        queue.offer("Task 1");
        queue.offer("Task 2");
        queue.offer("Task 3");
        System.out.println("Size after 3 offers: " + queue.size()); // Expected: 3
        System.out.println("Front element (peek): " + queue.peek()); // Expected: Task 1

        // 3. Test poll() (Dequeue)
        System.out.println("\n[Test: Polling elements]");
        System.out.println("Polled: " + queue.poll()); // Expected: Task 1
        System.out.println("Polled: " + queue.poll()); // Expected: Task 2
        System.out.println("New Front: " + queue.peek()); // Expected: Task 3

        // 4. Test polling until empty (Boundary Case)
        System.out.println("\n[Test: Polling last element]");
        System.out.println("Polled last: " + queue.poll()); // Expected: Task 3
        System.out.println("Is queue empty now? " + queue.isEmpty()); // Expected: true

        // 5. Test Error Handling (Exception Case)
        try {
            System.out.println("\n[Test: Polling from empty queue]");
            queue.poll();
        } catch (IllegalStateException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }

        System.out.println("\n--- Queue Testing Completed ---");
    }
}
