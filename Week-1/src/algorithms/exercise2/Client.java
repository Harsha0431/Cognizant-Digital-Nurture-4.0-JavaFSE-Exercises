package algorithms.exercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static Product linearSearch(List<Product> products, String targetName) {
        for (Product product: products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(List<Product> products, String targetName) {
        int left = 0;
        int right = products.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Product midProduct = products.get(mid);
            int cmp = midProduct.getProductName().compareToIgnoreCase(targetName);

            if (cmp == 0) {
                return midProduct;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(101, "iPhone", "Mobile"));
        products.add(new Product(102, "MacBook", "Laptop"));
        products.add(new Product(103, "Galaxy Watch", "Watch"));
        products.add(new Product(104, "Dell XPS", "Laptop"));
        products.add(new Product(105, "OnePlus", "Mobile"));

        System.out.println("Product List:");
        for (Product product : products) {
            System.out.println(product);
        }

         // ---- Linear Search ----
        String searchName1 = "OnePlus";
        long startLinear = System.nanoTime();
        Product result1 = linearSearch(products, searchName1);
        long endLinear = System.nanoTime();
        long durationLinear = endLinear - startLinear;
        System.out.println("\nLinear Search Result for '" + searchName1 + "': " + result1);
        System.out.println("Time taken for Linear Search: " + durationLinear + " ns");

        // ---- Binary Search ----
        Collections.sort(products, (p1, p2) ->
            p1.getProductName().compareToIgnoreCase(p2.getProductName())
        );

        String searchName2 = "MacBook";
        long startBinary = System.nanoTime();
        Product result2 = binarySearch(products, searchName2);
        long endBinary = System.nanoTime();
        long durationBinary = endBinary - startBinary;
        System.out.println("\nBinary Search Result for '" + searchName2 + "': " + result2);
        System.out.println("Time taken for Binary Search: " + durationBinary + " ns");
    }
}
