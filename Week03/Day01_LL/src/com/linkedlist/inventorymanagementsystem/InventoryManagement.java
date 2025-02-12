package com.linkedlist.inventorymanagementsystem;

class InventoryManagement {
    private ItemNode head;

    public InventoryManagement() {
        head = null;
    }

    // Add an item at the beginning
    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        ItemNode newItem = new ItemNode(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add an item at the end
    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        ItemNode newItem = new ItemNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            ItemNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newItem;
        }
    }

    // Add an item at a specific position
    public void addItemAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        ItemNode newItem = new ItemNode(itemName, itemId, quantity, price);
        if (position == 1) {
            addItemAtBeginning(itemName, itemId, quantity, price);
            return;
        }

        ItemNode current = head;
        int currentPosition = 1;
        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            System.out.println("Position out of range!");
        } else {
            newItem.next = current.next;
            current.next = newItem;
        }
    }

    // Remove an item based on Item ID
    public void removeItemById(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        if (head.itemId == itemId) {
            head = head.next;
            return;
        }

        ItemNode current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Item with ID " + itemId + " not found.");
        } else {
            current.next = current.next.next;
        }
    }

    // Update the quantity of an item based on Item ID
    public void updateItemQuantity(int itemId, int newQuantity) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                System.out.println("Quantity updated for item ID " + itemId);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item ID
    public void searchItemById(int itemId) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                System.out.println("Item found: " + current.itemName + ", ID: " + current.itemId +
                        ", Quantity: " + current.quantity + ", Price: " + current.price);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item Name
    public void searchItemByName(String itemName) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item found: " + current.itemName + ", ID: " + current.itemId +
                        ", Quantity: " + current.quantity + ", Price: " + current.price);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with name " + itemName + " not found.");
    }

    // Calculate and display the total value of the inventory
    public void calculateTotalInventoryValue() {
        double totalValue = 0;
        ItemNode current = head;
        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }
        System.out.println("Total inventory value: $" + totalValue);
    }

    // Sort the inventory by Item Name (ascending order)
    public void sortInventoryByName() {
        if (head == null || head.next == null) {
            return;
        }
        head = mergeSortByName(head);
    }

    // Merge Sort by Item Name (ascending order)
    private ItemNode mergeSortByName(ItemNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ItemNode middle = getMiddle(node);
        ItemNode nextOfMiddle = middle.next;
        middle.next = null;

        ItemNode left = mergeSortByName(node);
        ItemNode right = mergeSortByName(nextOfMiddle);

        return mergeByName(left, right);
    }

    // Merge two sorted lists by Item Name
    private ItemNode mergeByName(ItemNode left, ItemNode right) {
        if (left == null) return right;
        if (right == null) return left;

        if (left.itemName.compareToIgnoreCase(right.itemName) < 0) {
            left.next = mergeByName(left.next, right);
            return left;
        } else {
            right.next = mergeByName(left, right.next);
            return right;
        }
    }

    // Get the middle node of the linked list
    private ItemNode getMiddle(ItemNode node) {
        if (node == null) return null;

        ItemNode slow = node, fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Display all items in the inventory
    public void displayInventory() {
        if (head == null) {
            System.out.println("No items in the inventory.");
            return;
        }
        ItemNode current = head;
        while (current != null) {
            System.out.println("Item Name: " + current.itemName + ", Item ID: " + current.itemId +
                    ", Quantity: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }
}
