package design.patterns.creational.factory;

/*
Factory Design Pattern:
- It Provides an interface for creating objects in a superclass, allowing subclasses to alter the type of objects that will be created.
* Category: Creational Design Pattern
- Useful when the exact types of objects to be created may vary or need to be determined at runtime.


Components
1. Creator: (DocumentFactory.java)
    This is an abstract class or an interface that declares the factory method.
    The creator typically contains a method that serves as a factory for creating objects.

2. Concrete Creator: (WordDocumentFactory.java, ExcelDocumentFactory.java, PdfDocumentFactory.java)
    Concrete Creator classes are subclasses of the Creator that implement the factory method to create specific types of objects.
    Each Concrete Creator is responsible for creating a particular product.

3. Product: (Document.java)
    This is the interface or abstract class for the objects that the factory method creates.
    The Product defines the common interface for all objects that the factory method can create.

4. Concrete Product: (WordDocument.java, ExcelDocument.java, PdfDocument.java)
    Concrete Product classes are the actual objects that the factory method creates.
    Each Concrete Product class implements the Product interface or extends the Product abstract class.


Advantages:
- It promotes loose coupling. Client class will be loosely coupled with Product classes.
- Promotes Open-Closed Principle where our client class is open to add new products by simply creating corresponding factories.
- Satisfies Single Responsibility Principle. You can move the product creation code into one place in the program, making the code easier to support.


Resources:
1. https://refactoring.guru/design-patterns/factory-method
2. https://www.geeksforgeeks.org/system-design/factory-method-for-designing-pattern/


* Look into Abstract Factory Design Pattern
*/

import java.util.Scanner;

public class DocumentFactoryTest {

    private static Document getDocument(String type){
        DocumentFactory documentFactory;
        if(type.equalsIgnoreCase("word"))
            documentFactory = new WordDocumentFactory();
        else if(type.equalsIgnoreCase("pdf"))
            documentFactory = new PdfDocumentFactory();
        else if (type.equalsIgnoreCase("excel"))
            documentFactory = new ExcelDocumentFactory();
        else
            throw new IllegalArgumentException("Provide valid document type.");

        return documentFactory.createDocument();
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter document type either pdf, word or excel: ");
        String type = read.nextLine();

        Document document = getDocument(type);

        document.save();
        document.open();
    }
}
