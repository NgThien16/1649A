package project_brief.library;

import project_brief.model.Book;

public class BinarySearch {
//    public int search(int[] arr, int target) {
//        int left = 0;
//        int right = arr.length - 1;
//
//        while (left <= right) {
//            int middle = (left + right) / 2;
//
//            if (arr[middle] == target) {
//                return middle;
//            }
//
//            if (target < arr[middle]) {
//                right = middle - 1;
//            } else {
//                left = middle + 1;
//            }
//        }
//
//        return -1;
//    }

    public static int search(ArrayListADT<Book> list, String target, String type) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midValue = "";

            // Lấy giá trị so sánh tùy theo tiêu chí
            if (type.equalsIgnoreCase("title")) {
                midValue = list.get(mid).getTitle();
            } else if (type.equalsIgnoreCase("author")) {
                midValue = list.get(mid).getAuthor();
            }

            int comparison = midValue.trim().compareToIgnoreCase(target.trim());

            if (comparison == 0) return mid; // Tìm thấy!

            if (comparison < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // Không tìm thấy
    }
}
