package design.patterns.behavioral;

public class WebApp implements Observer {
    private String name;

    public WebApp(String name) {
        this.name = name;
    }

    @Override
    public void update(double stockPrice) {
        System.out.println(name + " (Web App) received stock update: Rs." + stockPrice);
    }

    @Override
    public String toString() {
        return "WebApp: " + name;
    }
}
