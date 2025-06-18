package design.patterns.structural.adapter;

public class StripeAdapter implements PaymentProcessor {
    // Need to set value to this while creating object
    private final StripeGateway stripe;

    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.makeStripePayment(amount);
    }
}
