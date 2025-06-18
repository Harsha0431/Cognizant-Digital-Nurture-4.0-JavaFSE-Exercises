package design.patterns.creational.factory;

public class WordDocument implements Document{
    @Override
    public void save() {
        System.out.println("Save Word document...");
    }

    @Override
    public void open() {
        System.out.println("Open Word document...");
    }
}
