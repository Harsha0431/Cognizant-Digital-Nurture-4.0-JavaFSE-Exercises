package algorithms.exercise2;

public class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return "Product{" +
               "productId=" + productId +
               ", productName='" + productName + '\'' +
               ", category='" + category + '\'' +
               '}';
    }
}

