package com.cts.dsa.taskmanager;

public class TaskLinkedList {
    private Task head;

    public void addTask(Task newTask) {
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
        System.out.println("✅ Added: " + newTask.taskName);
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("❌ No tasks to delete.");
            return;
        }

        if (head.taskId == taskId) {
            System.out.println("🗑️ Deleted: " + head.taskName);
            head = head.next;
            return;
        }

        Task prev = head;
        Task curr = head.next;
        while (curr != null) {
            if (curr.taskId == taskId) {
                prev.next = curr.next;
                System.out.println("🗑️ Deleted: " + curr.taskName);
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("❌ Task not found.");
    }

    public void searchTask(int taskId) {
        Task current = head;
        while (current != null) {
            if (current.taskId == taskId) {
                System.out.println("🔍 Found: " + current);
                return;
            }
            current = current.next;
        }
        System.out.println("❌ Task ID not found.");
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("📭 No tasks to display.");
            return;
        }

        System.out.println("📋 Task List:");
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}
