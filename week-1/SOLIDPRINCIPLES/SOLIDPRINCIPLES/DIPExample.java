package SOLIDPRINCIPLES;

interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    public void sendMessage(String message) {
        System.out.println("Email: " + message);
    }
}

class Notification {
    MessageService service;

    Notification(MessageService service) {
        this.service = service;
    }

    void notifyUser() {
        service.sendMessage("You have a new message");
    }
}

public class DIPExample {
    public static void main(String[] args) {
        MessageService emailService = new EmailService();
        Notification notification = new Notification(emailService);
        notification.notifyUser();
    }
}
