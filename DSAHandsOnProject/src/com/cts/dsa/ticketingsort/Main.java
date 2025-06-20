package com.cts.dsa.ticketingsort;

public class Main {
    public static void main(String[] args) {
        SupportTicket[] tickets1 = {
                new SupportTicket(701, "Login Issue", 12),
                new SupportTicket(702, "Server Down", 5),
                new SupportTicket(703, "Payment Failed", 18),
                new SupportTicket(704, "Bug Report", 9)
        };

        SupportTicket[] tickets2 = tickets1.clone(); // for merge sort

        // Insertion Sort
        System.out.println("📋 Tickets sorted using Insertion Sort:");
        TicketSorter.insertionSort(tickets1);
        for (SupportTicket t : tickets1) System.out.println(t);

        // Merge Sort
        System.out.println("\n📋 Tickets sorted using Merge Sort:");
        TicketSorter.mergeSort(tickets2, 0, tickets2.length - 1);
        for (SupportTicket t : tickets2) System.out.println(t);
    }
}
