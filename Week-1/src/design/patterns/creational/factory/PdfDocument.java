package design.patterns.creational.factory;

public class PdfDocument implements Document{
    @Override
    public void save() {
        System.out.println("Save PDF document...");
    }

    @Override
    public void open() {
        System.out.println("Open PDF document...");
    }
}
