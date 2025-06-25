package design.patterns.structural.decorator;

/*
* Decorator is a **structural design pattern** that lets you attach new behaviors to objects by placing these objects inside
*   special wrapper objects that contain the behaviors.
*
* Here we use Composition and Association i.e, where a class wraps other class.
*
* Association:
*   - A general relationship between two classes where one class uses or is connected to another.
*   - Associated objects can exist independently of each other.
*
* Composition - "Part-of" relationship (strong association)
*   A specialized form of association that represents a whole-part relationship where the part cannot exist without the whole.
*   When the container object is destroyed, the contained objects are destroyed too.
*/

public class NotificationTest {
    public static void main(String[] args) {
        Notifier baseNotifier = new EmailNotifier();

        Notifier smsNotifier = new SMSNotifierDecorator(baseNotifier);

        Notifier fullNotifier = new SlackNotifierDecorator(smsNotifier);

        fullNotifier.send("Hello! How have you been?");
    }
}
