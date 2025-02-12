package com.linkedlist.socialmediafriend;

import java.util.*;
class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friendListHead; // Head of the list of friends
    UserNode next; // Pointer to the next user in the singly linked list

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendListHead = null;
        this.next = null;
    }

    // Add a friend ID to the user's friend list
    public void addFriend(int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        if (friendListHead == null) {
            friendListHead = newFriend;
        } else {
            FriendNode current = friendListHead;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newFriend;
        }
    }

    // Remove a friend ID from the user's friend list
    public void removeFriend(int friendId) {
        if (friendListHead == null) return;

        if (friendListHead.friendId == friendId) {
            friendListHead = friendListHead.next;
            return;
        }

        FriendNode current = friendListHead;
        while (current.next != null && current.next.friendId != friendId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Display all friends of the user
    public void displayFriends() {
        if (friendListHead == null) {
            System.out.println(name + " has no friends.");
            return;
        }

        FriendNode current = friendListHead;
        System.out.print(name + "'s Friends: ");
        while (current != null) {
            System.out.print(current.friendId + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Find mutual friends between this user and another user
    public void findMutualFriends(UserNode otherUser) {
        if (this.friendListHead == null || otherUser.friendListHead == null) {
            System.out.println("No mutual friends.");
            return;
        }

        List<Integer> mutualFriends = new ArrayList<>();
        FriendNode thisCurrent = this.friendListHead;
        while (thisCurrent != null) {
            FriendNode otherCurrent = otherUser.friendListHead;
            while (otherCurrent != null) {
                if (thisCurrent.friendId == otherCurrent.friendId) {
                    mutualFriends.add(thisCurrent.friendId);
                    break;
                }
                otherCurrent = otherCurrent.next;
            }
            thisCurrent = thisCurrent.next;
        }

        if (mutualFriends.isEmpty()) {
            System.out.println("No mutual friends.");
        } else {
            System.out.println("Mutual friends: " + mutualFriends);
        }
    }
}

class FriendNode {
    int friendId;
    FriendNode next;

    public FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}
