package com.cts.dsa.employeemanagement;

public class Employee {
    private int id;
    private String name;
    private String position;

    public Employee(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee[" + id + ", " + name + ", " + position + "]";
    }
}
