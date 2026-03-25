package project_brief.testing;

import project_brief.library.LinkedStackADT;

public class StackTest {
    public static void main(String[] args) {
        LinkedStackADT<String> stack = new LinkedStackADT<>();

        System.out.println("--- Starting LinkedStackADT Testing ---");

        // 1. Test push()
        System.out.println("\n[Test 1: Pushing elements]");
        stack.push("Page 1");
        stack.push("Page 2");
        stack.push("Page 3");
        System.out.println("Stack after 3 pushes: " + stack.toString());
        // Expected: [Page 3, Page 2, Page 1] (LIFO order)

        // 2. Test peek()
        System.out.println("\n[Test 2: Peeking top element]");
        System.out.println("Top element: " + stack.peek()); // Expected: Page 3

        // 3. Test pop()
        System.out.println("\n[Test 3: Popping elements]");
        System.out.println("Popped: " + stack.pop()); // Expected: Page 3
        System.out.println("Stack after pop: " + stack.toString()); // Expected: [Page 2, Page 1]

        // 4. Test size() and isEmpty()
        System.out.println("\n[Test 4: Utility methods]");
        System.out.println("Current size: " + stack.size()); // Expected: 2
        System.out.println("Is empty? " + stack.isEmpty()); // Expected: false

        // 5. Test clear()
        System.out.println("\n[Test 5: Clearing stack]");
        stack.clear();
        System.out.println("Size after clear: " + stack.size()); // Expected: 0
        System.out.println("Is empty now? " + stack.isEmpty()); // Expected: true

        // 6. Test Exception
        try {
            System.out.println("\n[Test 6: Popping from empty stack]");
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }

        System.out.println("\n--- Stack Testing Completed ---");
    }
}
