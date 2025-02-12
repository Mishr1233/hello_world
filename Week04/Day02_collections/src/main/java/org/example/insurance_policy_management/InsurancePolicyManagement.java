package org.example.insurance_policy_management;

import java.util.*;
import java.time.LocalDate;

class InsurancePolicy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate,
                           String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Getters
    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Policyholder: " + policyholderName +
                ", Expiry Date: " + expiryDate + ", Coverage: " + coverageType + ", Premium: " + premiumAmount;
    }
}

public class InsurancePolicyManagement{

    // HashMap to store policies by policy number
    private static Map<String, InsurancePolicy> policyMap = new HashMap<>();
    // LinkedHashMap to store policies while maintaining insertion order
    private static Map<String, InsurancePolicy> linkedPolicyMap = new LinkedHashMap<>();
    // List to store policies sorted by expiry date
    private static List<InsurancePolicy> sortedPoliciesList = new ArrayList<>();

    // Method to add a policy to the system
    public static void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        linkedPolicyMap.put(policy.getPolicyNumber(), policy);
        sortedPoliciesList.add(policy);
    }

    // Method to retrieve a policy by its number
    public static InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // Method to list all policies expiring within the next 30 days
    public static List<InsurancePolicy> getPoliciesExpiringSoon() {
        List<InsurancePolicy> expiringSoonPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysLater = today.plusDays(30);
        for (InsurancePolicy policy : policyMap.values()) {
            if (!policy.getExpiryDate().isBefore(today) && policy.getExpiryDate().isBefore(thirtyDaysLater)) {
                expiringSoonPolicies.add(policy);
            }
        }
        return expiringSoonPolicies;
    }

    // Method to list all policies for a specific policyholder
    public static List<InsurancePolicy> getPoliciesByPolicyholder(String policyholderName) {
        List<InsurancePolicy> policiesForHolder = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                policiesForHolder.add(policy);
            }
        }
        return policiesForHolder;
    }

    // Method to remove expired policies
    public static void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        // We should collect expired policies first and then remove them to avoid concurrent modification.
        List<String> expiredPolicies = new ArrayList<>();
        for (Map.Entry<String, InsurancePolicy> entry : policyMap.entrySet()) {
            if (entry.getValue().getExpiryDate().isBefore(today)) {
                expiredPolicies.add(entry.getKey());
            }
        }
        for (String policyNumber : expiredPolicies) {
            policyMap.remove(policyNumber);
            linkedPolicyMap.remove(policyNumber);
            sortedPoliciesList.removeIf(policy -> policy.getPolicyNumber().equals(policyNumber));
        }
    }

    // Method to display all policies (can be sorted by expiry date)
    public static void displayPolicies() {
        // Sort the policies by expiry date
        sortedPoliciesList.sort(Comparator.comparing(InsurancePolicy::getExpiryDate));
        for (InsurancePolicy policy : sortedPoliciesList) {
            System.out.println(policy);
        }
    }

    // Main method to test the system
    public static void main(String[] args) {
        // Creating some sample policies
        InsurancePolicy policy1 = new InsurancePolicy("P001", "Alice", LocalDate.of(2025, 6, 15), "Health", 500);
        InsurancePolicy policy2 = new InsurancePolicy("P002", "Bob", LocalDate.of(2025, 5, 20), "Auto", 700);
        InsurancePolicy policy3 = new InsurancePolicy("P003", "Alice", LocalDate.of(2025, 4, 10), "Home", 300);
        InsurancePolicy policy4 = new InsurancePolicy("P004", "Carol", LocalDate.of(2024, 8, 25), "Health", 400);

        // Adding policies to the system
        addPolicy(policy1);
        addPolicy(policy2);
        addPolicy(policy3);
        addPolicy(policy4);

        // Retrieve a policy by number
        System.out.println("Policy P001: " + getPolicyByNumber("P001"));

        // List all policies expiring soon
        System.out.println("\nPolicies expiring soon:");
        List<InsurancePolicy> expiringPolicies = getPoliciesExpiringSoon();
        for (InsurancePolicy policy : expiringPolicies) {
            System.out.println(policy);
        }

        // List all policies for a specific policyholder
        System.out.println("\nPolicies for Alice:");
        List<InsurancePolicy> alicePolicies = getPoliciesByPolicyholder("Alice");
        for (InsurancePolicy policy : alicePolicies) {
            System.out.println(policy);
        }

        // Remove expired policies
        removeExpiredPolicies();

        // Display all remaining policies (sorted by expiry date)
        System.out.println("\nRemaining Policies after removal of expired ones:");
        displayPolicies();
    }
}
