package com.linkedlist.librarymanagementsystem;


public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        // Add books to the library
        library.addBookAtBeginning("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 101, true);
        library.addBookAtEnd("1984", "George Orwell", "Dystopian", 102, true);
        library.addBookAtEnd("To Kill a Mockingbird", "Harper Lee", "Fiction", 103, true);
        library.addBookAtPosition(2, "Moby Dick", "Herman Melville", "Adventure", 104, true);

        // Display books in forward order
        System.out.println("Books in library (Forward):");
        library.displayBooksForward();

        // Search for a book by Title
        library.searchBookByTitle("1984");

        // Search for a book by Author
        library.searchBookByAuthor("George Orwell");

        // Update availability status of a book
        library.updateBookAvailabilityStatus(102, false);

        // Display books in reverse order
        System.out.println("\nBooks in library (Reverse):");
        library.displayBooksReverse();

        // Count total number of books
        System.out.println("\nTotal number of books in library: " + library.countTotalBooks());

        // Remove a book by Book ID
        library.removeBookById(101);

        // Display books after removal
        System.out.println("\nBooks after removal:");
        library.displayBooksForward();
    }
}

