package com.cts.dsa.employeemanagement;

public class Main {
    public static void main(String[] args) {
        ShiftManager shiftManager = new ShiftManager(5); // max 5 employees per shift

        Employee e1 = new Employee(1, "Aarav", "Manager");
        Employee e2 = new Employee(2, "Bhavya", "Support");
        Employee e3 = new Employee(3, "Chandan", "IT");
        Employee e4 = new Employee(4, "Deepa", "HR");

        shiftManager.addEmployee(e1);
        shiftManager.addEmployee(e2);
        shiftManager.addEmployee(e3);
        shiftManager.addEmployee(e4);

        shiftManager.displayShift();

        shiftManager.searchEmployee(3);
        shiftManager.removeEmployeeById(2);
        shiftManager.removeEmployeeById(99); // not found

        System.out.println("\n🔄 After updates:");
        shiftManager.displayShift();
    }
}
