package proiectPAO.repository;

import proiectPAO.model.products.FoodProduct;
import proiectPAO.model.products.FurnitureProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodProductRepositoryDB {
    public final Connection connection;

    public FoodProductRepositoryDB(Connection connection) {
        this.connection = connection;
    }

    public void add(FoodProduct foodProduct) throws SQLException {
        String sql = "INSERT INTO foodproduct VALUES (NULL, ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, foodProduct.getName());
        statement.setDouble(2, foodProduct.getPrice());
        statement.setInt(3, foodProduct.getQuantity());
        statement.setDouble(4, foodProduct.getDiscount());
        statement.setBoolean(5, foodProduct.isExpired());

        statement.executeUpdate();
        statement.close();
    }

    public void delete(String name) throws SQLException {
        String sqlDelete = "DELETE FROM foodproduct WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(sqlDelete);
        statement.setString(1, name);
        statement.executeUpdate();
    }

    public List<FoodProduct> getAll() throws SQLException {
        List<FoodProduct> foodProducts = new ArrayList<FoodProduct>();

        String sql = "SELECT * FROM foodproduct";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            FoodProduct a = new FoodProduct(rs.getInt(1), rs.getString(2),
                    rs.getDouble(3), rs.getInt(4), rs.getDouble(5), rs.getBoolean(6));
            foodProducts.add(a);
        }
        return foodProducts;
    }

    public FoodProduct findByName(String name) throws SQLException {
        List<FoodProduct> foodProducts = new ArrayList<FoodProduct>();

        String sql = "SELECT * FROM foodproduct WHERE name = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);

        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            FoodProduct a = new FoodProduct(rs.getInt(1), rs.getString(2),
                    rs.getDouble(3), rs.getInt(4), rs.getDouble(5), rs.getBoolean(6));
            return a;
        }
        return null;
    }

    public void changePriceOfProduct(String name, double newPrice) throws SQLException {
        String sql = "UPDATE foodproduct SET price = ? WHERE name = ?";
        PreparedStatement statement =  connection.prepareStatement(sql);
        statement.setDouble(1, newPrice);
        statement.setString(2, name);
        statement.executeUpdate();
    }

    public List<FoodProduct> findByExpired() throws SQLException {
        List<FoodProduct> foodProducts = new ArrayList<FoodProduct>();

        String sql = "SELECT * FROM foodproduct WHERE isExpired = true ";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            FoodProduct a = new FoodProduct(rs.getInt(1), rs.getString(2),
                    rs.getDouble(3), rs.getInt(4), rs.getDouble(5), rs.getBoolean(6));
            foodProducts.add(a);
        }
        return foodProducts;
    }

}
