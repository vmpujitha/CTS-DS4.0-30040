package DESIGNPATTERNS;

interface Vehicle {
    void start();
}

class Bike implements Vehicle {
    public void start() {
        System.out.println("Bike started. Vroom!");
    }
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Car started. Zoom!");
    }
}

class VehicleFactory {
    public Vehicle createVehicle(String type) {
        if (type.equalsIgnoreCase("Bike"))
            return new Bike();
        else if (type.equalsIgnoreCase("Car"))
            return new Car();
        return null;
    }
}

public class VehicalFactory {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();
        Vehicle myVehicle = factory.createVehicle("Car");
        myVehicle.start();
    }
}
