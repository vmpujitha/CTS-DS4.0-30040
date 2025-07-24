package decorator;

public class Main {
    public static void main(String[] args) {
        Notifier emailOnly = new EmailNotifier();
        emailOnly.send("Server is down!");

        System.out.println("--- With SMS Decorator ---");

        Notifier emailWithSMS = new SMSDecorator(new EmailNotifier());
        emailWithSMS.send("Server is down!");
    }
}
