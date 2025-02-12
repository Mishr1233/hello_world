package com.linkedlist.taskscheduler;

class TaskScheduler {
    private TaskNode head;
    private TaskNode tail;

    public TaskScheduler() {
        head = null;
        tail = null;
    }

    // Add a task at the beginning
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;  // Circular link
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;  // Maintain the circular nature
        }
    }

    // Add a task at the end
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;  // Circular link
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;  // Maintain the circular nature
        }
    }

    // Add a task at a specific position
    public void addTaskAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (position == 1) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        TaskNode current = head;
        int currentPosition = 1;
        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            System.out.println("Position out of range!");
        } else {
            newTask.next = current.next;
            current.next = newTask;
            if (current == tail) {
                tail = newTask;  // Update tail if added at the end
            }
        }
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        TaskNode current = head;
        TaskNode previous = null;

        // If the task to be removed is the head
        if (head.taskId == taskId) {
            if (head == tail) {  // Only one task in the list
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;  // Maintain circular nature
            }
            return;
        }

        // Search for the task and remove it
        do {
            previous = current;
            current = current.next;
            if (current.taskId == taskId) {
                previous.next = current.next;
                if (current == tail) {
                    tail = previous;  // Update tail if the last task is removed
                }
                return;
            }
        } while (current != head);

        System.out.println("Task with ID " + taskId + " not found.");
    }

    // View the current task and move to the next task
    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode current = head;
        do {
            System.out.println("Task ID: " + current.taskId + ", Task Name: " + current.taskName +
                    ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Display all tasks starting from the head
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        TaskNode current = head;
        do {
            System.out.println("Task ID: " + current.taskId + ", Task Name: " + current.taskName +
                    ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Search for a task by Priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode current = head;
        boolean found = false;
        do {
            if (current.priority == priority) {
                System.out.println("Task ID: " + current.taskId + ", Task Name: " + current.taskName +
                        ", Due Date: " + current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }
}

