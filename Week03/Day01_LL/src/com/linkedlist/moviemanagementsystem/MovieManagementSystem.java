package com.linkedlist.moviemanagementsystem;

public class MovieManagementSystem{
    public static void main(String[] args) {
        MovieList system = new MovieList();

        // Add movies
        system.addMovieAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        system.addMovieAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        system.addMovieAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        system.addMovieAtPosition(2, "Dunkirk", "Christopher Nolan", 2017, 8.4);

        // Display movies
        System.out.println("Movies in Forward Order:");
        system.displayMoviesForward();

        // Update a movie's rating
        system.updateMovieRating("Inception", 9.2);

        // Search for a movie by Director
        System.out.println("\nMovies by Director 'Christopher Nolan':");
        system.searchMovieByDirector("Christopher Nolan");

        // Search for a movie by Rating
        System.out.println("\nMovies with Rating 8.8:");
        system.searchMovieByRating(8.8);

        // Remove a movie by title
        system.removeMovieByTitle("Dunkirk");

        // Display movies in reverse order
        System.out.println("\nMovies in Reverse Order:");
        system.displayMoviesReverse();
    }
}
