package project_brief.library;

import project_brief.model.Book;

public class MergeSort {
    public static void sort(ArrayListADT<Book> list, int left, int right, String type) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            sort(list, left, middle, type);
            sort(list, middle + 1, right, type);
            merge(list, left, middle, right, type);
        }
    }

    private static void merge(ArrayListADT<Book> list, int left, int middle, int right, String type) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Book[] leftArray = new Book[n1];
        Book[] rightArray = new Book[n2];

        for (int i = 0; i < n1; ++i) leftArray[i] = list.get(left + i);
        for (int j = 0; j < n2; ++j) rightArray[j] = list.get(middle + 1 + j);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            boolean condition;
            if (type.equalsIgnoreCase("title")) {
                condition = leftArray[i].getTitle().compareToIgnoreCase(rightArray[j].getTitle()) <= 0;
            } else {
                condition = leftArray[i].getAuthor().compareToIgnoreCase(rightArray[j].getAuthor()) <= 0;
            }

            if (condition) {
                list.set(k, leftArray[i]);
                i++;
            } else {
                list.set(k, rightArray[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            list.set(k, leftArray[i]);
            i++; k++;
        }
        while (j < n2) {
            list.set(k, rightArray[j]);
            j++; k++;
        }
    }
}