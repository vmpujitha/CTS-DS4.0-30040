package com.cts.dsa.forecasting;

public class Main {
    public static void main(String[] args) {
        double initialUsers = 1000;
        double growthRate = 10.0; // 10% monthly growth
        int forecastMonths = 6;

        double predictedUsersRecursive = UserGrowthPredictor.predictUsers(0, forecastMonths, initialUsers, growthRate);
        double predictedUsersIterative = UserGrowthPredictor.predictUsersIterative(forecastMonths, initialUsers, growthRate);

        System.out.printf("📈 Predicted Users after %d months (Recursive): %.2f%n", forecastMonths, predictedUsersRecursive);
        System.out.printf("📉 Predicted Users after %d months (Iterative): %.2f%n", forecastMonths, predictedUsersIterative);
    }
}
