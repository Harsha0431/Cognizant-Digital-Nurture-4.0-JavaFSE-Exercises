package design.patterns.structural.adapter;

public class RazorpayAdapter implements PaymentProcessor {
    // Need to set value to this while creating object
    private final RazorpayGateway paypal;

    public RazorpayAdapter(RazorpayGateway paypal) {
        this.paypal = paypal;
    }

    @Override
    public void processPayment(double amount) {
        paypal.sendPayment(amount);
    }
}
