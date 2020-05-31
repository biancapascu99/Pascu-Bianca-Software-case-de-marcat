package proiectPAO.model.products;

public abstract class Product {

    protected String name;
    protected double price;
    protected int quantity;
    protected double discount;

    public Product() {
    }

    public Product(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = 0;
    }

    public Product(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = 1;
        this.discount = discount;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 1;
        this.discount = 0;
    }

    public abstract double priceQuantity();

    public abstract String toString();

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
