package com.cts.dsa.ticketingsort;

public class SupportTicket {
    private int ticketId;
    private String issue;
    private int responseTime; // in minutes

    public SupportTicket(int ticketId, String issue, int responseTime) {
        this.ticketId = ticketId;
        this.issue = issue;
        this.responseTime = responseTime;
    }

    public int getResponseTime() {
        return responseTime;
    }

    @Override
    public String toString() {
        return "Ticket[" + ticketId + ", " + issue + ", Waiting: " + responseTime + " mins]";
    }
}
