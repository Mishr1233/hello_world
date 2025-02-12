package com.linkedlist.inventorymanagementsystem;


public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        // Add items to the inventory
        inventory.addItemAtBeginning("Laptop", 101, 10, 999.99);
        inventory.addItemAtEnd("Mouse", 102, 50, 19.99);
        inventory.addItemAtEnd("Keyboard", 103, 30, 49.99);
        inventory.addItemAtPosition(2, "Monitor", 104, 15, 199.99);

        // Display the inventory
        System.out.println("Inventory:");
        inventory.displayInventory();

        // Update quantity of an item
        inventory.updateItemQuantity(102, 60);

        // Search for an item by Item ID
        inventory.searchItemById(103);

        // Calculate total inventory value
        inventory.calculateTotalInventoryValue();

        // Sort inventory by Item Name
        System.out.println("\nInventory sorted by Item Name:");
        inventory.sortInventoryByName();
        inventory.displayInventory();

        // Remove an item by Item ID
        inventory.removeItemById(101);
        System.out.println("\nInventory after removal:");
        inventory.displayInventory();
    }
}
