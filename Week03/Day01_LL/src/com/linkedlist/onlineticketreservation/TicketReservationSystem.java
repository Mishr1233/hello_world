package com.linkedlist.onlineticketreservation;

import java.util.*;

public class TicketReservationSystem {

    private class TicketNode {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        TicketNode next;

        public TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    private TicketNode head;
    private TicketNode tail;
    private int ticketCount;

    public TicketReservationSystem() {
        this.head = null;
        this.tail = null;
        this.ticketCount = 0;
    }

    // Add a new ticket reservation at the end of the circular list
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = newTicket;
            tail = newTicket;
            newTicket.next = head; // Circular link
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head; // Maintain circular link
        }
        ticketCount++;
    }

    // Remove a ticket by Ticket ID
    public boolean removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return false;
        }

        TicketNode current = head;
        TicketNode previous = null;

        // Check if the ticket to remove is the head node
        if (current.ticketId == ticketId) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head; // Update the circular link
            }
            ticketCount--;
            return true;
        }

        // Traverse the list to find the ticket
        do {
            previous = current;
            current = current.next;
            if (current.ticketId == ticketId) {
                previous.next = current.next;
                if (current == tail) {
                    tail = previous; // Update tail if last node is removed
                }
                ticketCount--;
                return true;
            }
        } while (current != head);

        System.out.println("Ticket not found.");
        return false;
    }

    // Display all tickets in the circular list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets in the system.");
            return;
        }

        TicketNode current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketId);
            System.out.println("Customer Name: " + current.customerName);
            System.out.println("Movie Name: " + current.movieName);
            System.out.println("Seat Number: " + current.seatNumber);
            System.out.println("Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String searchTerm) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        TicketNode current = head;
        boolean found = false;
        do {
            if (current.customerName.contains(searchTerm) || current.movieName.contains(searchTerm)) {
                System.out.println("Ticket ID: " + current.ticketId);
                System.out.println("Customer Name: " + current.customerName);
                System.out.println("Movie Name: " + current.movieName);
                System.out.println("Seat Number: " + current.seatNumber);
                System.out.println("Booking Time: " + current.bookingTime);
                System.out.println("--------------------------------");
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tickets found matching the search term.");
        }
    }

    // Calculate the total number of booked tickets
    public int totalTickets() {
        return ticketCount;
    }
}

