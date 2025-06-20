package com.cts.dsa.taskmanager;

public class Main {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        Task t1 = new Task(101, "Finish DSA Assignment", "Pending", "2025-06-20");
        Task t2 = new Task(102, "Push Code to GitHub", "Pending", "2025-06-21");
        Task t3 = new Task(103, "Attend Java Session", "Done", "2025-06-19");

        taskList.addTask(t1);
        taskList.addTask(t2);
        taskList.addTask(t3);

        taskList.displayTasks();

        taskList.searchTask(102);
        taskList.deleteTask(101);

        System.out.println("\n🔁 Updated Task List:");
        taskList.displayTasks();
    }
}
