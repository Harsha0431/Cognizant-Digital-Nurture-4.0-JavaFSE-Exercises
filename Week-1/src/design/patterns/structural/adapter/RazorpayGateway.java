package design.patterns.structural.adapter;

public class RazorpayGateway {
    public void sendPayment(double amount) {
        System.out.println("Payment of Rs." + amount + " sent using PayPal.");
    }
}