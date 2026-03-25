package project_brief.testing;

import project_brief.library.ArrayListADT;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayListADT<String> list = new ArrayListADT<>();

        System.out.println("--- Starting ArrayListADT Testing ---");

        // 1. Test add() and resize()
        System.out.println("\n[Test 1: Insertion & Dynamic Resizing]");
        for (int i = 1; i <= 12; i++) {
            list.add("Element " + i);
        }
        System.out.println("Added 12 elements. Current size: " + list.size());
        // Expected: Size is 12, resize() triggered since initial capacity was 10.

        // 2. Test get()
        System.out.println("\n[Test 2: Element Retrieval]");
        System.out.println("Element at index 0: " + list.get(0));
        System.out.println("Element at index 11: " + list.get(11));

        // 3. Test set()
        System.out.println("\n[Test 3: Updating Elements]");
        String oldVal = list.set(5, "Updated 5");
        System.out.println("Old value at index 5: " + oldVal);
        System.out.println("New value at index 5: " + list.get(5));

        // 4. Test indexOf()
        System.out.println("\n[Test 4: Searching]");
        System.out.println("Index of 'Element 1': " + list.indexOf("Element 1"));
        System.out.println("Index of 'Updated 5': " + list.indexOf("Updated 5"));
        System.out.println("Index of 'Non-existent': " + list.indexOf("Ghost"));

        // 5. Test remove()
        System.out.println("\n[Test 5: Deletion & Shifting]");
        System.out.println("Size before removal: " + list.size());
        String removedVal = list.remove(0); // Remove first element
        System.out.println("Removed: " + removedVal);
        System.out.println("New element at index 0 (shifted): " + list.get(0));
        System.out.println("Current size: " + list.size());

        // 6. Test Error Handling (Boundary Cases)
        System.out.println("\n[Test 6: Exception Handling]");
        try {
            list.get(100);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }

        System.out.println("\n--- All Tests Completed Successfully ---");
    }
}
