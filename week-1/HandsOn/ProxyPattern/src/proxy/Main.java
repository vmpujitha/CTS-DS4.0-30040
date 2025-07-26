package proxy;

public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("design-patterns.png");

        System.out.println("Image created but not loaded yet.");

        image1.display(); // loads and displays
        System.out.println("Calling display again...");
        image1.display(); // displays without loading again
    }
}
