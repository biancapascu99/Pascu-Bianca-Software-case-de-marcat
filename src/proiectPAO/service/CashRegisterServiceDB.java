package proiectPAO.service;

import proiectPAO.model.cashregisters.CashRegister;
import proiectPAO.repository.CardRepositoryDB;
import proiectPAO.repository.CashRegisterRepositoryDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CashRegisterServiceDB {

    private CashRegisterRepositoryDB cashRegisterRepositoryDB;

    public CashRegisterServiceDB (Connection connection) {
        cashRegisterRepositoryDB = new CashRegisterRepositoryDB(connection);
        System.out.println("CashRegisterRepositoryDB a fost creat");
    }
    public void addCashRegister(CashRegister p) throws SQLException {

//        auditService.writeData("CashRegisterService-addCashRegister");
        cashRegisterRepositoryDB.add(p);
    }


    public void changeNumberOfCashRegister(int number, int newNumber) throws SQLException {
//        auditService.writeData("CashRegisterService-changeNumberOfCashRegister");
        cashRegisterRepositoryDB.changeNumberOfCashRegister(number,newNumber);
    }

    public List<CashRegister> getCashRegister() throws SQLException {
//        auditService.writeData("CashRegisterService-getCashRegister");
        return cashRegisterRepositoryDB.getAll();
    }

    public void deleteByNumber(int number) throws SQLException {
//        auditService.writeData("CashRegisterService-deleteByNumber");
        cashRegisterRepositoryDB.delete(number);
    }

    public CashRegister findByNumber(int number) throws SQLException {
//        auditService.writeData("CashRegisterService-findByNumber");
        return cashRegisterRepositoryDB.findByNumber(number);
    }
}
