package com.linkedlist.roundrobinscheduling;

import java.util.*;

class RoundRobin {
    private ProcessNode head;
    private int totalProcesses;

    public RoundRobin() {
        head = null;
        totalProcesses = 0;
    }

    // Add a new process to the circular list at the end
    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newProcess = new ProcessNode(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            head.next = head;  // Circular linked list
        } else {
            ProcessNode current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newProcess;
            newProcess.next = head;  // Maintain the circular nature
        }
        totalProcesses++;
    }

    // Remove a process by Process ID
    public void removeProcessById(int processId) {
        if (head == null) {
            System.out.println("No processes in the list.");
            return;
        }

        ProcessNode current = head;
        ProcessNode prev = null;
        do {
            if (current.processId == processId) {
                if (prev == null) {  // head node is to be removed
                    if (current.next == head) {  // Only one process in the list
                        head = null;
                    } else {
                        prev = head;
                        while (prev.next != head) {
                            prev = prev.next;
                        }
                        head = head.next;
                        prev.next = head;
                    }
                } else {
                    prev.next = current.next;
                }
                totalProcesses--;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        System.out.println("Process with ID " + processId + " not found.");
    }

    // Simulate the round-robin scheduling with a fixed time quantum
    public void roundRobinScheduling(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes in the list.");
            return;
        }

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int completedProcesses = 0;

        ProcessNode current = head;
        Map<Integer, Integer> waitingTimes = new HashMap<>();
        Map<Integer, Integer> turnaroundTimes = new HashMap<>();

        while (completedProcesses < totalProcesses) {
            if (current.burstTime > 0) {
                int executionTime = Math.min(current.burstTime, timeQuantum);
                current.burstTime -= executionTime;

                // Add execution time to turnaround time
                turnaroundTimes.put(current.processId, turnaroundTimes.getOrDefault(current.processId, 0) + executionTime);
                totalTurnaroundTime += executionTime;

                // If the process is completed
                if (current.burstTime == 0) {
                    completedProcesses++;
                    waitingTimes.put(current.processId, turnaroundTimes.get(current.processId) - turnaroundTimes.getOrDefault(current.processId, 0) - executionTime);
                    System.out.println("Process " + current.processId + " completed.");
                }
            }

            current = current.next;  // Move to next process
            displayProcesses();
        }

        // Calculate average waiting time and turnaround time
        System.out.println("Average Waiting Time: " + (totalWaitingTime / totalProcesses));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / totalProcesses));
    }

    // Display the list of processes in the circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the list.");
            return;
        }

        ProcessNode current = head;
        System.out.println("Current processes in the queue:");
        do {
            System.out.println("Process ID: " + current.processId + ", Burst Time: " + current.burstTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}
