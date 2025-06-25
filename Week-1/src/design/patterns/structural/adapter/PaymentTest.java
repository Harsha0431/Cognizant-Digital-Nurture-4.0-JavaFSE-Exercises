package design.patterns.structural.adapter;

/*
* Adapter is a **structural design pattern** that allows objects with incompatible interfaces to collaborate.
*
* Adapter: This is a special object that converts the interface of one object so that another object can understand it.
*
* Mainly used while working with different 3rd party applications or legacy applications or software.
*
* Advantages:
* 1. Follows Single Responsibility Principle.:
*   You can separate the interface or data conversion code from the primary business logic of the program.
*
* 2. Open/Closed Principle.
*   You can introduce new types of adapters into the program without breaking the existing client code, as long as they work with the adapters through the client interface.
* */

public class PaymentTest {
    public static void main(String[] args) {
        StripeGateway stripeGateway = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);
        // This method will execute whatever logic or workflow that need to run a payment with stripe.
        stripeProcessor.processPayment(100.0);

        // Using PayPal
        RazorpayGateway razorpayGateway = new RazorpayGateway();
        PaymentProcessor razorpayProcessor = new RazorpayAdapter(razorpayGateway);
        razorpayProcessor.processPayment(150.0);
    }
}
