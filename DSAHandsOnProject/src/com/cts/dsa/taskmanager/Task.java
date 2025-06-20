package com.cts.dsa.taskmanager;

public class Task {
    int taskId;
    String taskName;
    String status; // Pending or Done
    String deadline;

    Task next;

    public Task(int taskId, String taskName, String status, String deadline) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.deadline = deadline;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Task[" + taskId + ", " + taskName + ", " + status + ", Deadline: " + deadline + "]";
    }
}
