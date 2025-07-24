package observer;

public class Main {
    public static void main(String[] args) {
        Stock tataStock = new Stock();

        Observer app1 = new MobileApp("Groww");
        Observer app2 = new MobileApp("Zerodha");

        tataStock.register(app1);
        tataStock.register(app2);

        tataStock.setPrice(1025.5);  // All observers get notified
        tataStock.setPrice(1040.0);  // Another update
    }
}
