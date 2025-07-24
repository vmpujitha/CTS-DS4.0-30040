package SOLIDPRINCIPLES;

interface PaymentMethod {
    void pay();
}

class CreditCardPayment implements PaymentMethod {
    public void pay() {
        System.out.println("Paid with Credit Card.");
    }
}

class PaypalPayment implements PaymentMethod {
    public void pay() {
        System.out.println("Paid with PayPal.");
    }
}

class PaymentProcessor {
    public void process(PaymentMethod method) {
        method.pay();
    }
}

public class OCPExample {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        PaymentMethod creditCard = new CreditCardPayment();
        PaymentMethod paypal = new PaypalPayment();

        processor.process(creditCard);
        processor.process(paypal);
    }
}
