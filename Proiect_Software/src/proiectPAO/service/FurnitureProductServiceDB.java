package proiectPAO.service;

import proiectPAO.model.products.FurnitureProduct;
import proiectPAO.repository.FurnitureProductRepositoryDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class FurnitureProductServiceDB {

    private FurnitureProductRepositoryDB furnitureProductRepositoryDB;
    private AuditService auditService = AuditService.getInstance();

    public FurnitureProductServiceDB(Connection connection) {
        furnitureProductRepositoryDB = new FurnitureProductRepositoryDB(connection);
//        System.out.println("FoodProductServiceDB a fost creat");
    }

    public void addFurnitureProduct(FurnitureProduct p) throws SQLException {

        auditService.writeData(Thread.currentThread().getName() + ", addFurnitureProduct");
        furnitureProductRepositoryDB.add(p);
    }


    public void changePriceOfProduct(String name, double newPrice) throws SQLException {
        auditService.writeData(Thread.currentThread().getName() + ", changePriceOfProduct");
        furnitureProductRepositoryDB.changePriceOfProduct(name, newPrice);
    }

    public List<FurnitureProduct> getFurnitureProduct() throws SQLException {
        auditService.writeData(Thread.currentThread().getName() + ", getFurnitureProduct");
        return furnitureProductRepositoryDB.getAll();
    }

    public void deleteByName(String name) throws SQLException {
        auditService.writeData(Thread.currentThread().getName() + ", deleteByName");
        furnitureProductRepositoryDB.delete(name);
    }

    public FurnitureProduct findByName(String name) throws SQLException {
        auditService.writeData(Thread.currentThread().getName() + ", findByName");
        return furnitureProductRepositoryDB.findByName(name);
    }

    public List<FurnitureProduct> findByGuarantee() throws SQLException {
        auditService.writeData(Thread.currentThread().getName() + ", findByGuarantee");
        return furnitureProductRepositoryDB.findByGuarantee();
    }

    public List<FurnitureProduct> findByTransport() throws SQLException {
        auditService.writeData(Thread.currentThread().getName() + "' findByTransport");
        return furnitureProductRepositoryDB.findByTransport();
    }
}
