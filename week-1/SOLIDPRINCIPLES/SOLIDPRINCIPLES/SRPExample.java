package SOLIDPRINCIPLES;
class User {
    String name;

    User(String name) {
        this.name = name;
    }
}

// Class with only one responsibility: printing user info
class UserPrinter {
    void printUser(User user) {
        System.out.println("User: " + user.name);
    }
}

// Main class with only one responsibility: application entry point
public class SRPExample {
    public static void main(String[] args) {
        User user = new User("Karthik");
        new UserPrinter().printUser(user);
    }
}
