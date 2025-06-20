package com.cts.dsa.librarysearch;

import java.util.Arrays;
import java.util.Comparator;

public class LibrarySearchUtil {

    // Linear Search by Book Title
    public static Book linearSearchByTitle(Book[] books, String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    // Binary Search by Author
    public static Book binarySearchByAuthor(Book[] books, String author) {
        Arrays.sort(books, Comparator.comparing(Book::getAuthor));

        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].getAuthor().compareToIgnoreCase(author);
            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
