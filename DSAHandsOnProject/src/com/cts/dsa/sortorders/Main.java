package com.cts.dsa.sortorders;

public class Main {
    public static void main(String[] args) {
        SupportTicket[] tickets = {
                new SupportTicket(401, "Pujitha", "Low"),
                new SupportTicket(402, "Harsha", "High"),
                new SupportTicket(403, "Joe", "Medium"),
                new SupportTicket(404, "Jhon", "High"),
                new SupportTicket(405, "David", "Low")
        };

        System.out.println("📋 Original Tickets:");
        for (SupportTicket t : tickets) System.out.println(t);

        // Bubble Sort
        System.out.println("\n🔃 Tickets Sorted by Bubble Sort (by Priority):");
        TicketSorter.bubbleSort(tickets);
        for (SupportTicket t : tickets) System.out.println(t);

        // Quick Sort
        SupportTicket[] tickets2 = {
                new SupportTicket(401, "Karthik", "Low"),
                new SupportTicket(402, "Sneha", "High"),
                new SupportTicket(403, "Arjun", "Medium"),
                new SupportTicket(404, "Riya", "High"),
                new SupportTicket(405, "David", "Low")
        };

        System.out.println("\n⚡ Tickets Sorted by Quick Sort (by Priority):");
        TicketSorter.quickSort(tickets2, 0, tickets2.length - 1);
        for (SupportTicket t : tickets2) System.out.println(t);
    }
}
