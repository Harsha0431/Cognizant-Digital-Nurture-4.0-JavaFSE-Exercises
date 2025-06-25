package design.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Observer> observers;
    private double stockPrice;

    public StockMarket() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println(observer + " registered.");
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println(observer + " removed.");
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }

    public void setStockPrice(double price) {
        this.stockPrice = price;
        System.out.println("\nStock price updated to: Rs." + price);
        notifyObservers();
    }
}
