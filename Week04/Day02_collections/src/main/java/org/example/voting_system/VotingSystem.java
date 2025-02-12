package org.example.voting_system;

import java.util.*;

public class VotingSystem {

    // HashMap to store votes with candidates as keys and their vote counts as values
    private static Map<String, Integer> voteMap = new HashMap<>();
    // LinkedHashMap to store votes while maintaining the insertion order
    private static Map<String, Integer> voteOrderMap = new LinkedHashMap<>();

    // Method to cast a vote for a candidate
    public static void castVote(String candidate) {
        // Update vote count in HashMap
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);

        // Update vote count in LinkedHashMap
        voteOrderMap.put(candidate, voteOrderMap.getOrDefault(candidate, 0) + 1);
    }

    // Method to display the results in the order votes were cast
    public static void displayVotesInOrder() {
        System.out.println("Votes in order of casting:");
        for (Map.Entry<String, Integer> entry : voteOrderMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Method to display the results sorted by the number of votes
    public static void displayVotesSortedByVotes() {
        // Create a list from voteMap entries
        List<Map.Entry<String, Integer>> sortedVotes = new ArrayList<>(voteMap.entrySet());

        // Sort the list based on the vote count in descending order
        sortedVotes.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        System.out.println("\nVotes sorted by votes (highest first):");
        for (Map.Entry<String, Integer> entry : sortedVotes) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Method to get the total number of votes for each candidate
    public static void displayVotes() {
        System.out.println("\nTotal votes for each candidate:");
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Method to get the winner of the voting
    public static String getWinner() {
        return Collections.max(voteMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    // Main method to simulate the voting system
    public static void main(String[] args) {
        // Simulate casting votes
        castVote("Alice");
        castVote("Bob");
        castVote("Alice");
        castVote("Charlie");
        castVote("Bob");
        castVote("Alice");

        // Display the results in different orders
        displayVotes();
        displayVotesInOrder();
        displayVotesSortedByVotes();  // Display votes sorted by the number of votes

        System.out.println("\nWinner of the election: " + getWinner());
    }
}
