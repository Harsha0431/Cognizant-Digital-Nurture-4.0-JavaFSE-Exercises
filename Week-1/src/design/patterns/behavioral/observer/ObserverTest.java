package design.patterns.behavioral.observer;

/*
* Observer is a **behavioral design pattern** that lets you define a subscription mechanism to notify multiple objects
* about any events that happen to the object they’re observing.
*/

public class ObserverTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp1 = new MobileApp("User1");
        Observer webApp1 = new WebApp("User2");

        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(webApp1);

        stockMarket.setStockPrice(100.25);
        stockMarket.setStockPrice(102.75);

        stockMarket.removeObserver(webApp1);

        stockMarket.setStockPrice(98.50);
    }
}
