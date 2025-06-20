package com.cts.dsa.searchfunction;

import java.util.Arrays;
import java.util.Comparator;

public class CustomerSearchUtil {

    // Linear search by email (string)
    public static Customer searchByEmail(Customer[] customers, String email) {
        for (Customer c : customers) {
            if (c.getEmail().equalsIgnoreCase(email)) {
                return c;
            }
        }
        return null;
    }

    // Binary search by ID (int)
    public static Customer searchById(Customer[] customers, int id) {
        Arrays.sort(customers, Comparator.comparingInt(Customer::getCustomerId));
        int low = 0, high = customers.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (customers[mid].getCustomerId() == id) {
                return customers[mid];
            } else if (customers[mid].getCustomerId() < id) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
