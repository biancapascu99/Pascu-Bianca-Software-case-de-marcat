package proiectPAO.model.products;

import java.time.LocalDate;

public class FurnitureProduct extends Product {
    private boolean hasGuarantee;
    private double priceTransport;

    public FurnitureProduct(String name, double price, int quantity, double discount, boolean hasGuarantee, double priceTransport) {
        super(name, price, quantity, discount);
        this.hasGuarantee = hasGuarantee;
        this.priceTransport = priceTransport;
    }

    public FurnitureProduct(String name, double price, int quantity, double discount, boolean hasGuarantee) {
        super(name, price, quantity, discount);
        this.hasGuarantee = hasGuarantee;
    }

    public FurnitureProduct(String name, double price, int quantity, double discount, double priceTransport) {
        super(name, price, quantity, discount);
        this.priceTransport = priceTransport;
    }

    public FurnitureProduct(String name, double price, int quantity, double discount) {
        super(name, price, quantity, discount);
    }

    public FurnitureProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public FurnitureProduct(String name, double price, double discount) {
        super(name, price, discount);
    }

    public FurnitureProduct(String name, double price, double discount, boolean hasGuarantee, double priceTransport) {
        super(name, price, discount);
        this.priceTransport = priceTransport;
        this.hasGuarantee = hasGuarantee;
    }

    public FurnitureProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public double priceQuantity() {
        if (discount != 0 && priceTransport == 0)
            return (price - (discount / 100.0 * price)) * quantity;
        else if (discount != 0 && priceTransport != 0)
            return ((price - (discount / 100.0 * price)) * quantity) + priceTransport;
        else if (discount == 0 && priceTransport == 0)
            return price * quantity;

        return priceTransport + (price * quantity);
    }

    @Override
    public String toString() {
        return "Nume produs: " + this.name + " Pret: " + this.priceQuantity();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public int getQuantity() {
        return super.getQuantity();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public void setQuantity(int quantity) {
        super.setQuantity(quantity);
    }

    @Override
    public double getDiscount() {
        return super.getDiscount();
    }

    @Override
    public void setDiscount(double discount) {
        super.setDiscount(discount);
    }

    public boolean isHasGuarantee() {
        return hasGuarantee;
    }

    public void setHasGuarantee(boolean hasGuarantee) {
        this.hasGuarantee = hasGuarantee;
    }

    public double getPriceTransport() {
        return priceTransport;
    }

    public void setPriceTransport(double priceTransport) {
        this.priceTransport = priceTransport;
    }
}
