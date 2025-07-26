package DESIGNPATTERNS;

class Laptop {
    String ram, storage;

    public Laptop(String ram, String storage) {
        this.ram = ram;
        this.storage = storage;
    }

    public void specs() {
        System.out.println("Laptop with " + ram + " RAM and " + storage);
    }
}

class LaptopBuilder {
    String ram = "8GB", storage = "256GB";

    LaptopBuilder setRam(String r) {
        ram = r;
        return this;
    }

    LaptopBuilder setStorage(String s) {
        storage = s;
        return this;
    }

    Laptop build() {
        return new Laptop(ram, storage);
    }
}

public class Main5 {
    public static void main(String[] args) {
        Laptop l = new LaptopBuilder().setRam("16GB").build();
        l.specs();
    }
}
