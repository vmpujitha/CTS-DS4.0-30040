package com.cts.dsa.sortorders;

public class SupportTicket {
    private int ticketId;
    private String customerName;
    private String priority; // High, Medium, Low

    public SupportTicket(int ticketId, String customerName, String priority) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.priority = priority;
    }

    public int getPriorityValue() {
        return switch (priority.toLowerCase()) {
            case "high" -> 3;
            case "medium" -> 2;
            case "low" -> 1;
            default -> 0;
        };
    }

    @Override
    public String toString() {
        return "Ticket[" + ticketId + ", " + customerName + ", " + priority + "]";
    }
}
