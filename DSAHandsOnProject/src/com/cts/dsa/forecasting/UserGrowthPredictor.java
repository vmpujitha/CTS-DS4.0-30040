package com.cts.dsa.forecasting;

public class UserGrowthPredictor {

    // Recursive method to forecast user base
    public static double predictUsers(int currentMonth, int totalMonths, double users, double growthRate) {
        if (currentMonth == totalMonths) {
            return users;
        }
        double nextMonthUsers = users + (users * growthRate / 100);
        return predictUsers(currentMonth + 1, totalMonths, nextMonthUsers, growthRate);
    }

    // Optional: Iterative version for comparison
    public static double predictUsersIterative(int months, double users, double growthRate) {
        for (int i = 0; i < months; i++) {
            users += users * growthRate / 100;
        }
        return users;
    }
}
