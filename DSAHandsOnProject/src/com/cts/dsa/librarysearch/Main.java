package com.cts.dsa.librarysearch;

public class Main {
    public static void main(String[] args) {
        Book[] catalog = {
                new Book(601, "Java Fundamentals", "Amit Sharma"),
                new Book(602, "Data Structures", "Kavya Reddy"),
                new Book(603, "Operating Systems", "Ravi Teja"),
                new Book(604, "Database Systems", "Anjali Menon"),
                new Book(605, "Machine Learning", "Kiran Rao")
        };

        // Linear Search by Title
        System.out.println("🔍 Search by Title:");
        Book foundByTitle = LibrarySearchUtil.linearSearchByTitle(catalog, "Operating Systems");
        System.out.println(foundByTitle != null ? foundByTitle : "Book not found.");

        // Binary Search by Author
        System.out.println("\n🔍 Search by Author:");
        Book foundByAuthor = LibrarySearchUtil.binarySearchByAuthor(catalog, "Kiran Rao");
        System.out.println(foundByAuthor != null ? foundByAuthor : "Author not found.");
    }
}
