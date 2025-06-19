package design.patterns.behavioral.strategy;

/*
* Strategy is a behavioral design pattern that lets you define a family of algorithms,
* put each of them into a separate class, and make their objects interchangeable.
*
* The Strategy pattern suggests that you take a class that does something specific in a lot of different ways and extract all of these algorithms into separate classes called strategies.
*
* The original class, called context, must have a field for storing a reference to one of the strategies. The context delegates the work to a linked strategy object instead of executing it on its own.
*
* The context isn’t responsible for selecting an appropriate algorithm for the job. Instead, the client passes the desired strategy to the context.
*
*
* Applications:
*
* 1. Use the Strategy pattern when you want to use different variants of an algorithm within an object and be able to switch from one algorithm to another during runtime.
* 2. Use the Strategy when you have a lot of similar classes that only differ in the way they execute some behavior.
* 3. Use the pattern when your class has a massive conditional statement that switches between different variants of the same algorithm.
*
* Advantages:
* 1. You can replace inheritance with composition.
* 2. Open/Closed Principle. You can introduce new strategies without having to change the context.
*/

public class PaymentContext {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Payment strategy not set.");
            return;
        }
        paymentStrategy.pay(amount);
    }
}

