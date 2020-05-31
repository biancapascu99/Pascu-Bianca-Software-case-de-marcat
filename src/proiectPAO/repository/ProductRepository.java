package proiectPAO.repository;

import proiectPAO.model.products.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private List<Product> productList = new ArrayList<>();

    public void add(Product p) {
        productList.add(p);
    }

    public void add(List<Product> p) {
        productList.addAll(p);
    }

    public Product findByName(String name) {
        for (Product p : productList) {
            if (p != null) {
                if (name.equals(p.getName()))
                    return p;
            }
        }
        return null;
    }

    public List<Product> getAll() {
        return productList;
    }

    public void delete(String name) {
        productList.removeIf(p -> p.getName().equals(name));
    }

    public List<Product> findByExpired() {
        List<Product> productsExpired = new ArrayList<>();
        for (Product product : productList) {
            if (product instanceof FoodProduct && ((FoodProduct) product).isExpired())
                productsExpired.add(product);
            else if (product instanceof CleaningProduct && ((CleaningProduct) product).isExpired())
                productsExpired.add(product);
        }
        return productsExpired;
    }

    public List<Product> findByTransport() {
        List<Product> productsTransport = new ArrayList<>();
        for (Product product : productList) {
            if (product instanceof FurnitureProduct && ((FurnitureProduct) product).getPriceTransport() != 0)
                productsTransport.add(product);
            else if (product instanceof AppliancesProduct && ((AppliancesProduct) product).getPriceTransport() != 0)
                productsTransport.add(product);
            else if (product instanceof ClotheProduct && ((ClotheProduct) product).getPriceTransport() != 0)
                productsTransport.add(product);
        }
        return productsTransport;
    }

    public List<Product> findByGuarantee() {
        List<Product> productsGuarantee = new ArrayList<>();
        for (Product product : productList) {
            if (product instanceof FurnitureProduct && ((FurnitureProduct) product).isHasGuarantee())
                productsGuarantee.add(product);
            else if (product instanceof AppliancesProduct && ((AppliancesProduct) product).isHasGuarantee())
                productsGuarantee.add(product);
            else if (product instanceof ClotheProduct && ((ClotheProduct) product).isHasGuarantee())
                productsGuarantee.add(product);
        }
        return productsGuarantee;
    }
}
