package design.patterns.structural.proxy;

/*
* Proxy is a **structural design pattern** that lets you provide a substitute or placeholder for another object.
*
* A proxy controls access to the original object, allowing you to perform something either before or after the request
* gets through to the original object.
*
* Applications:
* 1. Lazy initialization (virtual proxy). This is when you have a heavyweight service object that wastes system resources
* by being always up, even though you only need it from time to time.
*
* 2. Logging requests (logging proxy). This is when you want to keep a history of requests to the service object.
*
* 3. Caching request results
*
* Advantages:
* - Open/Closed Principle
* - You can control the service object without clients knowing about it.
* - The proxy works even if the service object isn’t ready or is not available.
*
* Disadvantages:
* - The response from the service might get delayed.
*/

public class ProxyTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("img1.jpg");

        image1.display();  // Loads image from remote server

        System.out.println();

        image1.display();  // Check in cache if item exists or not then display

        System.out.println();
    }

}
