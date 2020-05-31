package proiectPAO.repository;


import proiectPAO.model.products.FurnitureProduct;
import proiectPAO.model.products.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FurnitureProductRepositoryDB {

    public final Connection connection;

    public FurnitureProductRepositoryDB(Connection connection) {
        this.connection = connection;
    }

    public void add(FurnitureProduct furnitureProduct) throws SQLException {
        String sql = "INSERT INTO furnitureproduct VALUES (NULL, ?, ?, ?, ?, ?,?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, furnitureProduct.getName());
        statement.setDouble(2, furnitureProduct.getPrice());
        statement.setInt(3, furnitureProduct.getQuantity());
        statement.setDouble(4, furnitureProduct.getDiscount());
        statement.setBoolean(6, furnitureProduct.isHasGuarantee());
        statement.setDouble(5, furnitureProduct.getPriceTransport());

        statement.executeUpdate();
        statement.close();
    }

    public void delete(String name) throws SQLException {
        String sqlDelete = "DELETE FROM furnitureproduct WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(sqlDelete);
        statement.setString(1, name);
        statement.executeUpdate();
    }

    public List<FurnitureProduct> getAll() throws SQLException {
        List<FurnitureProduct> furnitureProducts = new ArrayList<FurnitureProduct>();

        String sql = "SELECT * FROM furnitureproduct";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            FurnitureProduct a = new FurnitureProduct(rs.getInt(1), rs.getString(2),
                    rs.getDouble(3), rs.getInt(4), rs.getDouble(5), rs.getBoolean(6), rs.getDouble(7));
            furnitureProducts.add(a);
        }
        return furnitureProducts;
    }

    public FurnitureProduct findByName(String name) throws SQLException {
        List<FurnitureProduct> furnitureProducts = new ArrayList<FurnitureProduct>();

        String sql = "SELECT * FROM furnitureproduct WHERE name = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);

        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            FurnitureProduct a = new FurnitureProduct(rs.getInt(1), rs.getString(2),
                    rs.getDouble(3), rs.getInt(4), rs.getDouble(5), rs.getBoolean(6), rs.getDouble(7));
            return a;
        }
        return null;
    }

    public List<FurnitureProduct> findByGuarantee() throws SQLException {
        List<FurnitureProduct> furnitureProducts = new ArrayList<FurnitureProduct>();

        String sql = "SELECT * FROM furnitureproduct WHERE hasGuarantee = 1 ";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            FurnitureProduct a = new FurnitureProduct(rs.getInt(1), rs.getString(2),
                    rs.getDouble(3), rs.getInt(4), rs.getDouble(5), rs.getBoolean(6), rs.getDouble(7));
            furnitureProducts.add(a);
        }
        return furnitureProducts;
    }


    public List<FurnitureProduct> findByTransport() throws SQLException {
        List<FurnitureProduct> furnitureProducts = new ArrayList<FurnitureProduct>();

        String sql = "SELECT * FROM furnitureproduct WHERE priceTransport > 0.0 ";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            FurnitureProduct a = new FurnitureProduct(rs.getInt(1), rs.getString(2),
                    rs.getDouble(3), rs.getInt(4), rs.getDouble(5), rs.getBoolean(7), rs.getDouble(6));
            furnitureProducts.add(a);
        }
        return furnitureProducts;
    }

}
