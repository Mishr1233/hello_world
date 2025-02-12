package com.linkedlist.librarymanagementsystem;

class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean availabilityStatus;  // true for available, false for checked out
    BookNode next;
    BookNode prev;

    public BookNode(String title, String author, String genre, int bookId, boolean availabilityStatus) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availabilityStatus = availabilityStatus;
        this.next = null;
        this.prev = null;
    }
}

