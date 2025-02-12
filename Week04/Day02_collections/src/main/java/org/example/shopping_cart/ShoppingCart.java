package org.example.shopping_cart;

import java.util.*;

public class ShoppingCart {

    // HashMap to store product prices
    private static Map<String, Double> productPrices = new HashMap<>();

    private static Map<String, Double> cart = new LinkedHashMap<>();

    // Method to add a product with its price to the product list
    public static void addProduct(String productName, double price) {
        productPrices.put(productName, price);
    }

    // Method to add a product to the cart
    public static void addToCart(String productName) {
        if (productPrices.containsKey(productName)) {
            cart.put(productName, productPrices.get(productName));
            System.out.println(productName + " added to cart.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Method to remove a product from the cart
    public static void removeFromCart(String productName) {
        if (cart.containsKey(productName)) {
            cart.remove(productName);
            System.out.println(productName + " removed from cart.");
        } else {
            System.out.println("Product not in cart.");
        }
    }

    public static void displayCartInOrder() {
        System.out.println("\nItems in the cart (Order Added):");
        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    // Method to display products sorted by price (TreeMap)
    public static void displayCartSortedByPrice() {
        // Convert LinkedHashMap to a List for sorting by value
        List<Map.Entry<String, Double>> sortedList = new ArrayList<>(cart.entrySet());

        // Sort the list by price in ascending order
        sortedList.sort((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()));

        System.out.println("\nItems sorted by price:");
        for (Map.Entry<String, Double> entry : sortedList) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    // Method to display total price of items in the cart
    public static void displayTotalPrice() {
        double totalPrice = 0;
        for (double price : cart.values()) {
            totalPrice += price;
        }
        System.out.println("\nTotal Price: $" + totalPrice);
    }

    // Main method to simulate shopping cart actions
    public static void main(String[] args) {
        // Adding products to the product list
        addProduct("Laptop", 1200.99);
        addProduct("Smartphone", 899.50);
        addProduct("Headphones", 150.75);
        addProduct("Mouse", 25.99);
        addProduct("Keyboard", 45.99);

        // Adding products to the cart
        addToCart("Laptop");
        addToCart("Smartphone");
        addToCart("Mouse");

        // Display the cart in the order items were added
        displayCartInOrder();

        // Display the cart sorted by price
        displayCartSortedByPrice();

        // Display the total price of the cart
        displayTotalPrice();

        // Removing an item from the cart
        removeFromCart("Smartphone");

        displayCartInOrder();
        displayCartSortedByPrice();
        displayTotalPrice();
    }
}

