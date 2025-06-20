package com.cts.dsa.ticketingsort;

public class TicketSorter {

    // Insertion Sort by responseTime
    public static void insertionSort(SupportTicket[] tickets) {
        for (int i = 1; i < tickets.length; i++) {
            SupportTicket key = tickets[i];
            int j = i - 1;

            while (j >= 0 && tickets[j].getResponseTime() > key.getResponseTime()) {
                tickets[j + 1] = tickets[j];
                j--;
            }
            tickets[j + 1] = key;
        }
    }

    // Merge Sort by responseTime
    public static void mergeSort(SupportTicket[] tickets, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(tickets, left, mid);
            mergeSort(tickets, mid + 1, right);
            merge(tickets, left, mid, right);
        }
    }

    private static void merge(SupportTicket[] tickets, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        SupportTicket[] L = new SupportTicket[n1];
        SupportTicket[] R = new SupportTicket[n2];

        System.arraycopy(tickets, left, L, 0, n1);
        System.arraycopy(tickets, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i].getResponseTime() <= R[j].getResponseTime()) {
                tickets[k++] = L[i++];
            } else {
                tickets[k++] = R[j++];
            }
        }

        while (i < n1) tickets[k++] = L[i++];
        while (j < n2) tickets[k++] = R[j++];
    }
}
