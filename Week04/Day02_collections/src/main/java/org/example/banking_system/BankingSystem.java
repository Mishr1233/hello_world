package org.example.banking_system;

import java.util.*;

class BankAccount {
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Setters
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "AccountNumber: " + accountNumber + ", Balance: $" + balance;
    }
}

public class BankingSystem {

    // HashMap to store customer accounts
    private static Map<String, BankAccount> accounts = new HashMap<>();
    // Queue to store withdrawal requests
    private static Queue<String> withdrawalQueue = new LinkedList<>();

    // Method to create a new bank account
    public static void createAccount(String accountNumber, double balance) {
        if (!accounts.containsKey(accountNumber)) {
            BankAccount account = new BankAccount(accountNumber, balance);
            accounts.put(accountNumber, account);
            System.out.println("Account created: " + account);
        } else {
            System.out.println("Account with this number already exists.");
        }
    }

    // Method to deposit money into an account
    public static void depositMoney(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposited $" + amount + " into account " + accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to withdraw money from an account
    public static void withdrawMoney(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            withdrawalQueue.add(accountNumber); // Queue the withdrawal request
            System.out.println("Withdrawal request for account " + accountNumber + " added to queue.");
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to process withdrawal requests in the order they are received
    public static void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            BankAccount account = accounts.get(accountNumber);

            if (account != null) {
                // Perform the withdrawal
                if (account.withdraw(100)) {
                    System.out.println("Withdrawal of $100 processed for account " + accountNumber);
                } else {
                    System.out.println("Insufficient funds for account " + accountNumber);
                }
            } else {
                System.out.println("Account not found.");
            }
        }
    }

    // Method to display all accounts sorted by balance
    public static void displayAccountsSortedByBalance() {
        // Convert the map entries to a list for sorting
        List<Map.Entry<String, BankAccount>> accountList = new ArrayList<>(accounts.entrySet());

        // Sort the list by balance
        accountList.sort((entry1, entry2) -> Double.compare(entry1.getValue().getBalance(), entry2.getValue().getBalance()));

        System.out.println("\nAccounts sorted by balance:");
        for (Map.Entry<String, BankAccount> entry : accountList) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Create some accounts
        createAccount("A1001", 500.00);
        createAccount("A1002", 1000.00);
        createAccount("A1003", 200.00);
        createAccount("A1004", 1500.00);

        // Deposit money into accounts
        depositMoney("A1001", 200.00);
        depositMoney("A1003", 100.00);

        // Process some withdrawal requests
        withdrawMoney("A1001", 100); // Request to withdraw $100 from A1001
        withdrawMoney("A1002", 100); // Request to withdraw $100 from A1002
        withdrawMoney("A1003", 100); // Request to withdraw $100 from A1003

        // Process withdrawals
        processWithdrawals();
        
        displayAccountsSortedByBalance();
    }
}

