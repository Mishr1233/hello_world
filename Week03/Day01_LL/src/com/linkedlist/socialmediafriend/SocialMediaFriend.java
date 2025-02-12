package com.linkedlist.socialmediafriend;

public class SocialMediaFriend {
    public static void main(String[] args) {
        // Create a social media system
        SocialMediaSystem system = new SocialMediaSystem();

        // Add users
        system.addUser(1, "Alice", 25);
        system.addUser(2, "Bob", 30);
        system.addUser(3, "Charlie", 22);
        system.addUser(4, "David", 27);

        // Add friend connections
        system.addFriendConnection(1, 2); // Alice and Bob
        system.addFriendConnection(1, 3); // Alice and Charlie
        system.addFriendConnection(2, 3); // Bob and Charlie
        system.addFriendConnection(3, 4); // Charlie and David

        // Display friends of a user
        system.displayFriends(1); // Alice's friends
        system.displayFriends(2); // Bob's friends
        system.displayFriends(3); // Charlie's friends

        // Find mutual friends
        system.findMutualFriends(1, 2); // Alice and Bob's mutual friends
        system.findMutualFriends(1, 3); // Alice and Charlie's mutual friends
        system.findMutualFriends(2, 3); // Bob and Charlie's mutual friends

        // Count friends for each user
        system.countFriends();

        // Remove a friend connection
        system.removeFriendConnection(1, 2); // Alice and Bob

        // Display friends after removal
        system.displayFriends(1); // Alice's friends after removal
    }
}
