package proiectPAO.service;

import proiectPAO.model.products.Product;
import proiectPAO.repository.ProductRepository;

import javax.swing.text.html.StyleSheet;
import java.util.List;

public class ProductService {

    private static ProductService instance = new ProductService();
    private ProductRepository productRepository = new ProductRepository();

    private ProductService() {
        System.out.println("ProductService a fost creat.");
    }

    public static ProductService getInstance() {
        return instance;
    }

    public void changePriceOfProduct(String name, int price) {
        Product p = productRepository.findByName(name);
        p.setPrice(price);
    }

    public void changePriceOfProduct(String name, int price, double discount) {
        Product p = productRepository.findByName(name);
        p.setPrice(price);
        p.setDiscount(discount);
    }

    public List<Product> getProducts() {
        return productRepository.getAll();
    }

    public void addProduct(Product p) {
        productRepository.add(p);
    }

    public void addProduct(List<Product> p) {
        productRepository.add(p);
    }

    //    produse expirate
    public List<Product> getExpired() {
        return productRepository.findByExpired();
    }

    //    produse care au livrare
    public List<Product> getTransported() {
        return productRepository.findByTransport();
    }

    //    produse care au garantie
    public List<Product> getGuarantee() {
        return productRepository.findByGuarantee();
    }

    public void deleteByName(String name) {
        productRepository.delete(name);
    }

    public Product findByName(String name) {
        return productRepository.findByName(name);
    }
}
