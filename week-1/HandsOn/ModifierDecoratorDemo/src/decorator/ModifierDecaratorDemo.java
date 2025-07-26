package decorator;

// Component interface
interface Notifier {
    void send(String message);
}

// Concrete component
class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

// Decorator class
class SMSDecorator implements Notifier {
    private Notifier wrappedNotifier;

    public SMSDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message); // Call base notifier
        System.out.println("SMS sent: " + message); // Add extra behavior
    }
}
