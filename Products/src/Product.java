
public class Product {
    private final String type;
    private final String brand;
    private final String size;
    private final String color;
    private final double price;

    public Product(String type, String brand, String size, String color, double price) {
        this.type = type;
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public String getType() { return type; }
    public String getBrand() { return brand; }
    public String getSize() { return size; }
    public String getColor() { return color; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("%s %s (%s, %s) - %.2f", type, brand, size != null ? size : "N/A", color, price);
    }
}
