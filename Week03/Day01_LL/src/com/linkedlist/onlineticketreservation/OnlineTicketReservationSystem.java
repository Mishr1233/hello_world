package com.linkedlist.onlineticketreservation;

import java.util.*;

public class OnlineTicketReservationSystem  {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Add some ticket reservations
        system.addTicket(1, "Alice", "Avatar", "A1", "2025-01-28 10:00");
        system.addTicket(2, "Bob", "Avengers", "B3", "2025-01-28 12:00");
        system.addTicket(3, "Charlie", "Avatar", "A2", "2025-01-28 14:00");
        system.addTicket(4, "David", "Spider-Man", "C4", "2025-01-28 16:00");

        // Display all tickets
        System.out.println("All tickets:");
        system.displayTickets();

        // Search for tickets by customer name or movie name
        System.out.println("Search for tickets by 'Avatar':");
        system.searchTicket("Avatar");

        // Remove a ticket by Ticket ID
        System.out.println("Removing ticket with ID 2:");
        system.removeTicket(2);
        system.displayTickets();

        // Display total number of tickets
        System.out.println("Total tickets booked: " + system.totalTickets());
    }
}

