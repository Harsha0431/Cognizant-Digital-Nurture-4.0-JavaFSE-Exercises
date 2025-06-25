package design.patterns.creational.factory;

public class ExcelDocument implements Document{
    @Override
    public void save() {
        System.out.println("Save Excel document...");
    }

    @Override
    public void open() {
        System.out.println("Save Excel document...");
    }
}
