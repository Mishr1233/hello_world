package com.linkedlist.librarymanagementsystem;

class LibraryManagement {
    private BookNode head;
    private BookNode tail;

    public LibraryManagement() {
        head = null;
        tail = null;
    }

    // Add a book at the beginning
    public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean availabilityStatus) {
        BookNode newBook = new BookNode(title, author, genre, bookId, availabilityStatus);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add a book at the end
    public void addBookAtEnd(String title, String author, String genre, int bookId, boolean availabilityStatus) {
        BookNode newBook = new BookNode(title, author, genre, bookId, availabilityStatus);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add a book at a specific position
    public void addBookAtPosition(int position, String title, String author, String genre, int bookId, boolean availabilityStatus) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        BookNode newBook = new BookNode(title, author, genre, bookId, availabilityStatus);
        if (position == 1) {
            addBookAtBeginning(title, author, genre, bookId, availabilityStatus);
            return;
        }

        BookNode current = head;
        int currentPosition = 1;
        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            System.out.println("Position out of range!");
        } else {
            newBook.next = current.next;
            if (current.next != null) {
                current.next.prev = newBook;
            } else {
                tail = newBook;  // If added at the end
            }
            current.next = newBook;
            newBook.prev = current;
        }
    }

    // Remove a book by Book ID
    public void removeBookById(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        BookNode current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (current == tail) {
                    tail = tail.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Book with ID " + bookId + " has been removed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Search for a book by Book Title
    public void searchBookByTitle(String title) {
        BookNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                System.out.println("Book found: " + current.title + ", Author: " + current.author +
                        ", Genre: " + current.genre + ", Book ID: " + current.bookId + ", Available: " + (current.availabilityStatus ? "Yes" : "No"));
                return;
            }
            current = current.next;
        }
        System.out.println("Book with title '" + title + "' not found.");
    }

    // Search for a book by Author
    public void searchBookByAuthor(String author) {
        BookNode current = head;
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                System.out.println("Book found: " + current.title + ", Author: " + current.author +
                        ", Genre: " + current.genre + ", Book ID: " + current.bookId + ", Available: " + (current.availabilityStatus ? "Yes" : "No"));
            }
            current = current.next;
        }
    }

    // Update a book's Availability Status
    public void updateBookAvailabilityStatus(int bookId, boolean availabilityStatus) {
        BookNode current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.availabilityStatus = availabilityStatus;
                System.out.println("Availability status of book ID " + bookId + " has been updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("No books in the library.");
            return;
        }

        BookNode current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre +
                    ", Book ID: " + current.bookId + ", Available: " + (current.availabilityStatus ? "Yes" : "No"));
            current = current.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("No books in the library.");
            return;
        }

        BookNode current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre +
                    ", Book ID: " + current.bookId + ", Available: " + (current.availabilityStatus ? "Yes" : "No"));
            current = current.prev;
        }
    }

    // Count the total number of books
    public int countTotalBooks() {
        int count = 0;
        BookNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

