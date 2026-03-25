//package project_brief.testing;
//
//import project_brief.library.BinarySearch;
//
//public class BinarySearchTest {
//    public static void main(String[] args) {
//        BinarySearch bs = new BinarySearch();
//
//        // Input: Array must be sorted (result from Merge Sort)
//        int[] sortedData = {3, 9, 10, 27, 38, 43, 82};
//
//        System.out.println("--- [2.5.2] Binary Search Execution Testing ---");
//        System.out.print("Sorted Data: ");
//        printArray(sortedData);
//
//        // Test 1: Search for an element in the middle
//        int t1 = 27;
//        int r1 = bs.search(sortedData, t1);
//        System.out.println("Test 1: Search for " + t1 + " -> Found at index: " + r1);
//
//        // Test 2: Search for the first element
//        int t2 = 3;
//        int r2 = bs.search(sortedData, t2);
//        System.out.println("Test 2: Search for " + t2 + " -> Found at index: " + r2);
//
//        // Test 3: Search for the last element
//        int t3 = 82;
//        int r3 = bs.search(sortedData, t3);
//        System.out.println("Test 3: Search for " + t3 + " -> Found at index: " + r3);
//
//        // Test 4: Search for a non-existent element
//        int t4 = 50;
//        int r4 = bs.search(sortedData, t4);
//        System.out.println("Test 4: Search for " + t4 + " -> Result: " + r4 + " (Not Found)");
//
//        System.out.println("\n--- Binary Search Testing Completed ---");
//    }
//
//    // Manual print function to avoid using Arrays.toString()
//    public static void printArray(int[] arr) {
//        System.out.print("[");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
//        }
//        System.out.println("]");
//    }
//}
