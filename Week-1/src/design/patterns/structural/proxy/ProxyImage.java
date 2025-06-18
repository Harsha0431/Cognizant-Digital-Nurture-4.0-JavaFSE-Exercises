package design.patterns.structural.proxy;

import java.util.HashMap;
import java.util.Map;

public class ProxyImage implements Image {
    private String filename;
    private static Map<String, RealImage> imageCache = new HashMap<>();  // To cache data

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        RealImage realImage = imageCache.get(filename);

        if (realImage == null) {
            System.out.println("Image not cached. Loading...");
            realImage = new RealImage(filename);
            imageCache.put(filename, realImage);
        } else {
            System.out.println("Using cached image: " + filename);
        }

        realImage.display();
    }
}
