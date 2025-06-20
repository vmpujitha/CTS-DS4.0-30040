package com.cts.dsa.searchfunction;

public class Main {
    public static void main(String[] args) {
        Customer[] customers = {
                new Customer(301, "Akhil", "akhil@example.com"),
                new Customer(302, "Bhavana", "bhavana@example.com"),
                new Customer(303, "Chaitanya", "chai@example.com"),
                new Customer(304, "Divya", "divya@example.com")
        };

        // Linear Search by Email
        System.out.println("🔍 Search by Email:");
        Customer foundByEmail = CustomerSearchUtil.searchByEmail(customers, "chai@example.com");
        System.out.println(foundByEmail != null ? foundByEmail : "No customer found");

        // Binary Search by ID
        System.out.println("\n🔍 Search by Customer ID:");
        Customer foundById = CustomerSearchUtil.searchById(customers, 302);
        System.out.println(foundById != null ? foundById : "No customer found");
    }
}
