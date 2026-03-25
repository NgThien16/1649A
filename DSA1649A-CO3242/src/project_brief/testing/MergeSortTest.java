//package project_brief.testing;
//
//import project_brief.library.MergeSort;
//
//public class MergeSortTest {
//    public static void main(String[] args) {
//        MergeSort ms = new MergeSort();
//
//        System.out.println("--- [2.4.2] Merge Sort Execution Testing ---");
//
//        // Test Case 1: Standard Unsorted Array
//        int[] arr1 = {38, 27, 43, 3, 9, 82, 10};
//        System.out.println("\nScenario 1: Random Unsorted Data");
//        System.out.print("Input : ");
//        MergeSort.printArray(arr1);
//        ms.sort(arr1, 0, arr1.length - 1);
//        System.out.print("Output: ");
//        MergeSort.printArray(arr1);
//
//        // Test Case 2: Reverse Sorted Array (Worst Case)
//        int[] arr2 = {50, 40, 30, 20, 10};
//        System.out.println("\nScenario 2: Reverse Sorted Data");
//        System.out.print("Input : ");
//        MergeSort.printArray(arr2);
//        ms.sort(arr2, 0, arr2.length - 1);
//        System.out.print("Output: ");
//        MergeSort.printArray(arr2);
//
//        // Test Case 3: Array with Duplicates
//        int[] arr3 = {15, 5, 20, 5, 15, 10};
//        System.out.println("\nScenario 3: Data with Duplicates");
//        System.out.print("Input : ");
//        MergeSort.printArray(arr3);
//        ms.sort(arr3, 0, arr3.length - 1);
//        System.out.print("Output: ");
//        MergeSort.printArray(arr3);
//
//        // Test Case 4: Single Element Array (Boundary Case)
//        int[] arr4 = {100};
//        System.out.println("\nScenario 4: Single Element Boundary Test");
//        System.out.print("Input : ");
//        MergeSort.printArray(arr4);
//        ms.sort(arr4, 0, arr4.length - 1);
//        System.out.print("Output: ");
//        MergeSort.printArray(arr4);
//
//        System.out.println("\n--- End of Testing ---");
//    }
//}
