package com.linkedlist.moviemanagementsystem;

class MovieList {
    private MovieNode head;
    private MovieNode tail;

    public MovieList() {
        head = null;
        tail = null;
    }

    // Add a movie record at the beginning
    public void addMovieAtBeginning(String title, String director, int yearOfRelease, double rating) {
        MovieNode newMovie = new MovieNode(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add a movie record at the end
    public void addMovieAtEnd(String title, String director, int yearOfRelease, double rating) {
        MovieNode newMovie = new MovieNode(title, director, yearOfRelease, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add a movie record at a specific position
    public void addMovieAtPosition(int position, String title, String director, int yearOfRelease, double rating) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }
        MovieNode newMovie = new MovieNode(title, director, yearOfRelease, rating);
        if (position == 1) {
            addMovieAtBeginning(title, director, yearOfRelease, rating);
            return;
        }

        MovieNode current = head;
        int currentPosition = 1;
        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            System.out.println("Position out of range!");
        } else {
            newMovie.next = current.next;
            newMovie.prev = current;
            if (current.next != null) {
                current.next.prev = newMovie;
            }
            current.next = newMovie;
        }
    }

    // Remove a movie record by Movie Title
    public void removeMovieByTitle(String title) {
        MovieNode current = head;
        while (current != null && !current.title.equals(title)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Movie not found!");
            return;
        }

        if (current == head) {
            head = current.next;
        }
        if (current == tail) {
            tail = current.prev;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
    }

    // Search for a movie record by Director
    public void searchMovieByDirector(String director) {
        MovieNode current = head;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                System.out.println("Movie found: " + current.title + ", " + current.yearOfRelease + ", Rating: " + current.rating);
            }
            current = current.next;
        }
    }

    // Search for a movie record by Rating
    public void searchMovieByRating(double rating) {
        MovieNode current = head;
        while (current != null) {
            if (current.rating == rating) {
                System.out.println("Movie found: " + current.title + ", " + current.director + ", " + current.yearOfRelease);
            }
            current = current.next;
        }
    }

    // Display all movies in forward order
    public void displayMoviesForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }
        MovieNode current = head;
        while (current != null) {
            System.out.println(current.title + " | " + current.director + " | " + current.yearOfRelease + " | Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display all movies in reverse order
    public void displayMoviesReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }
        MovieNode current = tail;
        while (current != null) {
            System.out.println(current.title + " | " + current.director + " | " + current.yearOfRelease + " | Rating: " + current.rating);
            current = current.prev;
        }
    }

    // Update a movie's Rating based on Movie Title
    public void updateMovieRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = newRating;
                System.out.println("Rating updated for movie: " + title);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found!");
    }
}
