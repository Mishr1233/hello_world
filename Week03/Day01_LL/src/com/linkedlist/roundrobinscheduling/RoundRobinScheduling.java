package com.linkedlist.roundrobinscheduling;


public class RoundRobinScheduling {
    public static void main(String[] args) {
        RoundRobin scheduler = new RoundRobin();

        // Add processes to the scheduler
        scheduler.addProcess(1, 10, 1);  // Process 1 with burst time of 10
        scheduler.addProcess(2, 5, 2);   // Process 2 with burst time of 5
        scheduler.addProcess(3, 8, 3);   // Process 3 with burst time of 8
        scheduler.addProcess(4, 6, 4);   // Process 4 with burst time of 6

        // Display initial processes
        scheduler.displayProcesses();

        // Simulate round robin scheduling with a time quantum of 3
        scheduler.roundRobinScheduling(3);
    }
}
