package week6.L06_Searching;

public class BinarySearch {
    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (arr[middle] == target) {
                return middle;
            }

            if (target < arr[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }
}


class BinarySearchTest {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 6, 7};
        var searcher = new BinarySearch();
        var index = searcher.search(numbers, 6);
        System.out.println(index);
    }
}
