package design.patterns.structural.decorator;

public class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message); // This sends message to base notifier i.e., Email
        sendSlack(message);
    }

    private void sendSlack(String message) {
        System.out.println("Sending SLACK notification: " + message);
    }
}
