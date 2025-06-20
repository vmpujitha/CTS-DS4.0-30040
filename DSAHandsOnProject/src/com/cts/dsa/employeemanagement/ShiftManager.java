package com.cts.dsa.employeemanagement;

public class ShiftManager {
    private Employee[] shift;
    private int count;

    public ShiftManager(int capacity) {
        shift = new Employee[capacity];
        count = 0;
    }

    public void addEmployee(Employee emp) {
        if (count >= shift.length) {
            System.out.println("❌ Shift is full. Can't add " + emp);
            return;
        }
        shift[count++] = emp;
        System.out.println("✅ Added: " + emp);
    }

    public void removeEmployeeById(int id) {
        for (int i = 0; i < count; i++) {
            if (shift[i].getId() == id) {
                for (int j = i; j < count - 1; j++) {
                    shift[j] = shift[j + 1]; // shift left
                }
                shift[--count] = null;
                System.out.println("🗑️ Removed employee with ID: " + id);
                return;
            }
        }
        System.out.println("❌ Employee ID " + id + " not found.");
    }

    public void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (shift[i].getId() == id) {
                System.out.println("🔍 Found: " + shift[i]);
                return;
            }
        }
        System.out.println("❌ Employee not found.");
    }

    public void displayShift() {
        if (count == 0) {
            System.out.println("📭 No employees in today's shift.");
            return;
        }
        System.out.println("📋 Today's Shift:");
        for (int i = 0; i < count; i++) {
            System.out.println(shift[i]);
        }
    }
}
