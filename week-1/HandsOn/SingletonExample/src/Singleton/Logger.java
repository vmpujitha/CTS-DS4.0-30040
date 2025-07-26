package Singleton;

public class Logger {
    private static Logger instance;
    private int logCount = 0;

    // Private constructor
    private Logger() {
        System.out.println("Logger initialized.");
    }

    // Public method to get the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Custom log method
    public void log(String message) {
        logCount++;
        System.out.println("[LOG " + logCount + "]: " + message);
    }
}
