package com.linkedlist.taskscheduler;

public class TaskSchedularSystem{
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Add tasks
        scheduler.addTaskAtBeginning(1, "Task 1", 5, "2025-02-01");
        scheduler.addTaskAtEnd(2, "Task 2", 3, "2025-02-02");
        scheduler.addTaskAtEnd(3, "Task 3", 4, "2025-02-03");
        scheduler.addTaskAtPosition(2, 4, "Task 4", 2, "2025-02-04");

        // Display all tasks
        System.out.println("All tasks:");
        scheduler.displayTasks();

        // View current task
        System.out.println("\nViewing current task:");
        scheduler.viewCurrentTask();

        // Remove a task by Task ID
        scheduler.removeTaskById(2);

        // Display tasks after removal
        System.out.println("\nTasks after removal:");
        scheduler.displayTasks();

        // Search for a task by Priority
        System.out.println("\nSearching for tasks with priority 4:");
        scheduler.searchTaskByPriority(4);
    }
}
