package com.cts.dsa.sortorders;

public class TicketSorter {

    // Bubble Sort (Descending by priority value)
    public static void bubbleSort(SupportTicket[] tickets) {
        int n = tickets.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tickets[j].getPriorityValue() < tickets[j + 1].getPriorityValue()) {
                    SupportTicket temp = tickets[j];
                    tickets[j] = tickets[j + 1];
                    tickets[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort Helper
    public static void quickSort(SupportTicket[] tickets, int low, int high) {
        if (low < high) {
            int pi = partition(tickets, low, high);
            quickSort(tickets, low, pi - 1);
            quickSort(tickets, pi + 1, high);
        }
    }

    private static int partition(SupportTicket[] tickets, int low, int high) {
        SupportTicket pivot = tickets[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (tickets[j].getPriorityValue() >= pivot.getPriorityValue()) {
                i++;
                SupportTicket temp = tickets[i];
                tickets[i] = tickets[j];
                tickets[j] = temp;
            }
        }

        SupportTicket temp = tickets[i + 1];
        tickets[i + 1] = tickets[high];
        tickets[high] = temp;

        return i + 1;
    }
}
