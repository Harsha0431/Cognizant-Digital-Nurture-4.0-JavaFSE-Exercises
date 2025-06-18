package design.patterns.structural.adapter;

public class StripeGateway {
    public void makeStripePayment(double amount) {
        System.out.println("Payment of Rs." + amount + " processed using Stripe.");
    }
}
