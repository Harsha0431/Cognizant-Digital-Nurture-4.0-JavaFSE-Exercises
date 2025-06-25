package design.patterns.creational.singleton;


import java.util.Date;

/*
Singleton pattern:
Category: Creational Design Pattern

Definition:
Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class
exists in the Java Virtual Machine.

- Singleton pattern is used for logging, drivers objects, caching, and thread pool.

To implement a singleton pattern, we have different approaches, but all of them have the following common concepts.

- Private constructor to restrict instantiation of the class from other classes.
- Private static variable of the same class that is the only instance of the class.
- Public static method that returns the instance of the class,
this is the global access point for the outer world to get the instance of the singleton class.
*/
public class Driver {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        System.out.println("Called from Driver class: " + logger.sayHello());
        logger.setLoggerLoginDate(new Date());
        System.out.println("Driver class logger loginDate: " + logger.getLoggerLoginDate());

        // Run test class `runTest` method to check if Logger is using same instance or not
        Test.runTest();
    }
}


class Test{
    public static void runTest(){
        Logger logger = Logger.getLogger();
        System.out.println("Test class logger loginDate: " + logger.getLoggerLoginDate());
    }
}