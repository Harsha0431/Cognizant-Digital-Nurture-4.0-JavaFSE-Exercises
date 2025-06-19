package design.patterns.behavioral.strategy;

public class PaymentTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        PaymentStrategy creditCardPayment = new CreditCardPayment("123-456", "Harsha", "123");
        context.setPaymentStrategy(creditCardPayment);
        context.pay(250);

        PaymentStrategy payPalPayment = new PayPalPayment("harsha@gmail.com", "123456");
        context.setPaymentStrategy(payPalPayment);
        context.pay(150);
    }
}
