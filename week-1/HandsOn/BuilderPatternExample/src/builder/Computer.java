package builder;

public class Computer {
    // Required components
    private String CPU;
    private String RAM;

    // Optional components
    private String storage;
    private String graphicsCard;
    private String wifiCard;

    // Private constructor
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.wifiCard = builder.wifiCard;
    }

    public void showSpecs() {
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM);
        System.out.println("Storage: " + (storage != null ? storage : "None"));
        System.out.println("Graphics Card: " + (graphicsCard != null ? graphicsCard : "None"));
        System.out.println("WiFi Card: " + (wifiCard != null ? wifiCard : "None"));
        System.out.println("-------------------------------");
    }

    // Static nested Builder class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;
        private String wifiCard;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setWiFiCard(String wifiCard) {
            this.wifiCard = wifiCard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
