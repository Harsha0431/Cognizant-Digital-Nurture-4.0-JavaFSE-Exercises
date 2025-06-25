package design.patterns.creational.singleton;


import java.util.Date;

// This is singleton class which doesn't allow any other class to create an instance of it.
// Rather encourages other classes to share the same instance.
public class Logger {
    private static Logger logger; // If we initialize here itself then it is called eager initialization.
    private Date loginDate;

    // As the logger class is defined as private, JVM doesn't allow any other classes to create a instance of this class.
    private Logger(){}

    public static Logger getLogger(){
        if(logger == null)
            logger = new Logger(); // It is lazy initialization.
        return logger;
    }

    public String sayHello(){
        return "Hello, from Logger skeleton class";
    }

    public void setLoggerLoginDate(Date date){
        loginDate = date;
    }

    public Date getLoggerLoginDate(){
        return loginDate;
    }
}
