package observer;

import java.util.*;

// Subject (Stock) and Observer logic
interface Observer {
    void update(double price);
}

class Stock {
    private double price;
    private final List<Observer> observers = new ArrayList<>();

    public void register(Observer obs) {
        observers.add(obs);
    }

    public void setPrice(double newPrice) {
        price = newPrice;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(price);
        }
    }
}

// Concrete Observer
class MobileApp implements Observer {
    private final String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(double price) {
        System.out.println(appName + " received stock update: ₹" + price);
    }
}
