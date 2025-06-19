package design.patterns.behavioral.command;

/*
* Command is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request.
* This transformation lets you pass requests as a method arguments, delay or queue a request’s execution, and support undoable operations.
*
*
* Applications:
* 1. Use the Command pattern when you want to parametrize objects with operations.
* 2. Use the Command pattern when you want to queue operations, schedule their execution, or execute them remotely.
*
*
* Advantages:
* 1. Single Responsibility Principle
* 2. Open/Closed Principle
*
*
* Diff b/w command and strategy patterns
* - You can use Command to convert any operation into an object. The operation’s parameters become fields of that object. The conversion lets you defer execution of the operation, queue it, store the history of commands, send commands to remote services, etc.
* - Strategy usually describes different ways of doing the same thing, letting you swap these algorithms within a single context class.
*/

public class LightCommandTest {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
