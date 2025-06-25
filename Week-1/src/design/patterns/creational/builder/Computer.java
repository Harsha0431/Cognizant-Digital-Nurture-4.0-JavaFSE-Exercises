package design.patterns.creational.builder;

public class Computer {
    private final String CPU; // This value have to be set while creating a computer
    private final String RAM; // This value have to be set while creating a computer
    private final String storage;
    private final String graphicsCard;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
    }

    // Add setters and getters if needed

    public String toString() {
        return "Computer CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage + ", GraphicsCard=" + graphicsCard;
    }

    // As a static inner class, it cannot access non-static members of outer class directly
    public static class Builder { // As it is declared as static, it cannot access outer instance fields.
        private final String CPU; // This value have to be set while creating a computer
        private final String RAM; // This value have to be set while creating a computer
        private String storage;
        private String graphicsCard;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public void setStorage(String storage) {
            this.storage = storage;
        }

        public void setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

