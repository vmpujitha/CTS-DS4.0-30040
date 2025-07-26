package adapter;

public class Main {
    public static void main(String[] args) {
        LegacyPrinter legacyPrinter = new LegacyPrinter();
        ModernPrinter printer = new PrinterAdapter(legacyPrinter);

        printer.print("Printing using adapter pattern!");
    }
}
