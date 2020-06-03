package proiectPAO.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proiectPAO.model.cashregisters.CashRegister;

public class CashRegisterRepositoryDB {

    public final Connection connection;

    public CashRegisterRepositoryDB(Connection connection) {
        this.connection = connection;
    }

    public boolean login(String name,int number) throws SQLException {

        String sql = "SELECT * FROM cashRegister WHERE cashierName = ? AND cashierNumber = ?";
        PreparedStatement statement  = connection.prepareStatement(sql);
        statement.setString(1,name);
        statement.setInt(2, number);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return true;
        } else
            return false;

    }

    public void add(CashRegister cashRegister) throws SQLException {
        String sql = "INSERT INTO cashRegister VALUES (NULL, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cashRegister.getCashierName());
        statement.setInt(2, cashRegister.getNumberCashier());

        statement.executeUpdate();
        statement.close();
    }

    public void delete(int cashRegisterNumber) throws SQLException {
        String sqlDelete = "DELETE FROM cashRegister WHERE cashierNumber = ?";
        PreparedStatement statement = connection.prepareStatement(sqlDelete);
        statement.setInt(1, cashRegisterNumber);
        statement.executeUpdate();
    }

    public void changeNumberOfCashRegister(int number, int newNumber) throws SQLException {
        String sql = "UPDATE cashRegister SET cashierNumber = ? WHERE cashierNumber = ?";
        PreparedStatement statement =  connection.prepareStatement(sql);
        statement.setInt(1, newNumber);
        statement.setInt(2, number);
        statement.executeUpdate();
    }


    public CashRegister findByNumber(int cashRegisterNumber) throws SQLException {

        String sql = "SELECT * FROM cashRegister WHERE cashierNumber = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, cashRegisterNumber);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            CashRegister a = new CashRegister(rs.getString(2),
                    rs.getInt(3));
            return a;
        } else
            return null;
    }

    public List<CashRegister> getAll() throws SQLException {
        List<CashRegister> cashRegisters = new ArrayList<CashRegister>();

        String sql = "SELECT * FROM cashRegister";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            CashRegister a = new CashRegister(rs.getString(2),
                    rs.getInt(3));
            cashRegisters.add(a);
        }
        return cashRegisters;
    }


}