package proiectPAO.model.products;

public class CleaningProduct extends Product {

    private boolean isExpired;

    public CleaningProduct(String name, double price, int quantity, boolean isExpired) {
        super(name, price, quantity);
        this.isExpired = isExpired;
    }

    public CleaningProduct(String name, double price, int quantity, double discount) {
        super(name, price, quantity, discount);
    }

    public CleaningProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public CleaningProduct(String name, double price, double discount) {
        super(name, price, discount);
    }

    public CleaningProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public double priceQuantity() {
        if (discount != 0)
            return (price - (discount / 100.0 * price)) * quantity;
        else
            return price * quantity;
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

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    @Override
    public double getDiscount() {
        return super.getDiscount();
    }

    @Override
    public void setDiscount(double discount) {
        super.setDiscount(discount);
    }
}
