package builder;

public class Main {
    public static void main(String[] args) {
        // Basic configuration
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB")
                .build();

        // Gaming configuration
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .build();

        // Office configuration
        Computer officeComputer = new Computer.Builder("Ryzen 5", "16GB")
                .setStorage("512GB SSD")
                .setWiFiCard("Intel AX200")
                .build();

        // Show results
        System.out.println("Basic Computer:");
        basicComputer.showSpecs();

        System.out.println("Gaming Computer:");
        gamingComputer.showSpecs();

        System.out.println("Office Computer:");
        officeComputer.showSpecs();
    }
}
