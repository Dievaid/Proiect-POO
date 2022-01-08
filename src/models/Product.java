package models;

public class Product {
    private String productName;
    private Double price;
    private String category;

    public Product() { }

    /**
     * Getter
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Setter
     */
    public void setProductName(final String productName) {
        this.productName = productName;
    }

    /**
     * Getter
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Setter
     */
    public void setPrice(final Double price) {
        this.price = price;
    }

    /**
     * Getter
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter
     */
    public void setCategory(final String category) {
        this.category = category;
    }
}
