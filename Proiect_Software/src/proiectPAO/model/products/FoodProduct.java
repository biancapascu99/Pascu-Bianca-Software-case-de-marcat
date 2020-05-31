package proiectPAO.model.products;

public class FoodProduct extends Product {

    private int idProduct;
    private boolean isExpired;

    public FoodProduct() {
    }

    public FoodProduct(int idProduct, boolean isExpired) {
        this.idProduct = idProduct;
        this.isExpired = isExpired;
    }


    public FoodProduct( int idProduct,String name, double price, int quantity, double discount, boolean isExpired) {
        super(name, price, quantity, discount);
        this.idProduct = idProduct;
        this.isExpired = isExpired;
    }

    public FoodProduct(String name, double price, int quantity, int idProduct, boolean isExpired) {
        super(name, price, quantity);
        this.idProduct = idProduct;
        this.isExpired = isExpired;
    }

    public FoodProduct(String name, double price, double discount, int idProduct, boolean isExpired) {
        super(name, price, discount);
        this.idProduct = idProduct;
        this.isExpired = isExpired;
    }

    public FoodProduct(String name, double price, int quantity, boolean isExpired) {
        super(name, price, quantity);
        this.isExpired = isExpired;
    }
    public FoodProduct(String name, double price, int quantity, double discount,boolean isExpired) {
        super(name, price, quantity, discount);
        this.isExpired = isExpired;
    }

    public FoodProduct(String name, double price, int quantity, double discount) {
        super(name, price, quantity, discount);
        this.isExpired = false;
    }

    public FoodProduct(String name, double price, int quantity) {
        super(name, price, quantity);
        this.isExpired = false;
    }

    public FoodProduct(String name, double price, double discount) {
        super(name, price, discount);
        this.isExpired = false;
    }

    public FoodProduct(String name, double price) {
        super(name, price);
        this.isExpired = false;
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
        return "FoodProduct{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", discount=" + discount +
                ", isExpired=" + isExpired +
                "}\n";
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
