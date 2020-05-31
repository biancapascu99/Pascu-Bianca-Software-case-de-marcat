package proiectPAO.service;

import proiectPAO.model.products.Product;
import proiectPAO.repository.ProductRepository;

import javax.swing.text.html.StyleSheet;
import java.util.List;

public class ProductService {

    private static ProductService instance = new ProductService();
    private ProductRepository productRepository = new ProductRepository();
    private AuditService auditService = AuditService.getInstance();

    private ProductService() {
//        System.out.println("ProductService a fost creat.");
    }

    public static ProductService getInstance() {
        return instance;
    }

    public void changePriceOfProduct(String name, int price) {
        auditService.writeData("ProductService-changePriceOfProduct");
        Product p = productRepository.findByName(name);
        p.setPrice(price);
    }

    public void changePriceOfProduct(String name, int price, double discount) {
        auditService.writeData("ProductService-changePriceOfProduct");
        Product p = productRepository.findByName(name);
        p.setPrice(price);
        p.setDiscount(discount);
    }

    public List<Product> getProducts() {
        auditService.writeData("ProductService-getProduct");
        return productRepository.getAll();
    }

    public void addProduct(Product p) {
        auditService.writeData("ProductService-addProduct");
        productRepository.add(p);
    }

    public void addProduct(List<Product> p) {
        auditService.writeData("ProductService-addProduct");
        productRepository.add(p);
    }

    //    produse expirate
    public List<Product> getExpired() {
        auditService.writeData("ProductService-getExpired");
        return productRepository.findByExpired();
    }

    //    produse care au livrare
    public List<Product> getTransported() {
        auditService.writeData("ProductService-getTransported");
        return productRepository.findByTransport();
    }

    //    produse care au garantie
    public List<Product> getGuarantee() {
        auditService.writeData("ProductService-getGuarantee");
        return productRepository.findByGuarantee();
    }

    public void deleteByName(String name) {
        auditService.writeData("ProductService-deleteByName");
        productRepository.delete(name);
    }

    public Product findByName(String name) {
        auditService.writeData("ProductService-findByName");
        return productRepository.findByName(name);
    }
}
