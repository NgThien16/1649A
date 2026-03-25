package week6.L05_Sorting;

import java.util.Arrays;

public class MergeSort {
    public void sort(int[] arr) {

        // TODO

    }
}

class MergeSortTest {
    public static void main(String[] args) {
        //int[] numbers = {6, 10, 7, 5, 2, 4, 9, 8, 3};
//        int[] numbers = {6, 10};
//        int[] numbers = {6};
//        int[] numbers = {};
        int[] numbers = {38, 27, 43, 3, 9, 82, 10};

        System.out.println(Arrays.toString(numbers));
        var sorter = new MergeSort();
        sorter.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}