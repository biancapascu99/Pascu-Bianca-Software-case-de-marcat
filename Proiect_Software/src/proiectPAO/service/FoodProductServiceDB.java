package proiectPAO.service;


import proiectPAO.model.products.FoodProduct;
import proiectPAO.repository.FoodProductRepositoryDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class FoodProductServiceDB {

    private FoodProductRepositoryDB foodProductRepositoryDB;
    private AuditService auditService = AuditService.getInstance();


    public FoodProductServiceDB(Connection connection) {
        foodProductRepositoryDB = new FoodProductRepositoryDB(connection);
//        System.out.println("FoodProductServiceDB a fost creat");
    }

    public void addFoodProduct(FoodProduct p) throws SQLException {

        auditService.writeData(Thread.currentThread().getName() + ", addFoodProduct");
        foodProductRepositoryDB.add(p);
    }


    public void changePriceOfProduct(String name, double newPrice) throws SQLException {
        auditService.writeData(Thread.currentThread().getName() + ", changePriceOfProduct");
        foodProductRepositoryDB.changePriceOfProduct(name, newPrice);
    }

    public List<FoodProduct> getFoodProduct() throws SQLException {
        auditService.writeData(Thread.currentThread().getName() + ", getFoodProduct");
        return foodProductRepositoryDB.getAll();
    }

    public void deleteByName(String name) throws SQLException {
        auditService.writeData(Thread.currentThread().getName() + ", deleteByName");
        foodProductRepositoryDB.delete(name);
    }

    public FoodProduct findByName(String name) throws SQLException {
        auditService.writeData(Thread.currentThread().getName() + ", findByName");
        return foodProductRepositoryDB.findByName(name);
    }

    public List<FoodProduct> findByExpired() throws SQLException {
        auditService.writeData(Thread.currentThread().getName() + ", findByExpired");
        return foodProductRepositoryDB.findByExpired();
    }

}
