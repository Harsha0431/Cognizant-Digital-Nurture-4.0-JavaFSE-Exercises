package design.patterns.creational.builder;

/*
Builder is a creational design pattern that lets you construct complex objects step by step.
- This pattern allows us to produce different types and representations of an object using the same construction code.

Applications or Advantages:
- Used to get rid of a “telescoping constructor” i.e., To have multiple construction with different set of parameters.
- Single Responsibility Principle. We can isolate complex construction code from the business logic of the product.
*/


public class ComputerBuilderTest {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB").build();

        Computer.Builder gamingComputerBuilder = new Computer.Builder("AMD Ryzen 9", "32GB");
        // Add new features to basic computer
        gamingComputerBuilder.setStorage("1TB SSD");
        gamingComputerBuilder.setGraphicsCard("NVIDIA RTX 4080");

        Computer gamingComputer = gamingComputerBuilder.build();

        System.out.println("Basic Computer: " + basicComputer);
        System.out.println("Gaming Computer: " + gamingComputer);
    }
}
