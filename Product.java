package FINAL_EXAM;

public class Product  implements Comparable<Product>{
    private String id;
    private String name;
    private double price;
    private String description;
    private int quantity;

    public Product() {
    }

    public Product(String id, String name, double price, String description, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return this.id +
                "," + this.name +
                "," + this.price +
                "," + this.description +
                "," + this.quantity;
    }

    @Override
    public int compareTo(Product p) {
        return this.getName().compareTo(this.getName());
    }
}
