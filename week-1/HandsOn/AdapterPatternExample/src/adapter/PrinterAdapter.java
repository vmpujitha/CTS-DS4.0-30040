package adapter;

interface ModernPrinter {
    void print(String text);
}

// Adaptee - legacy class
class LegacyPrinter {
    public void oldPrint(String data) {
        System.out.println("Legacy Printer: " + data);
    }
}

// Adapter class
public class PrinterAdapter implements ModernPrinter {
    private LegacyPrinter legacyPrinter;

    public PrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public void print(String text) {
        legacyPrinter.oldPrint(text);
    }
}
