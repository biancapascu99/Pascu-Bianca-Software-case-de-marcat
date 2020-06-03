package proiectPAO.service;

import proiectPAO.model.cashregisters.CashRegister;
import proiectPAO.repository.CardRepositoryDB;
import proiectPAO.repository.CashRegisterRepositoryDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CashRegisterServiceDB {

    private CashRegisterRepositoryDB cashRegisterRepositoryDB;
    private AuditService auditService = AuditService.getInstance();

    public CashRegisterServiceDB(Connection connection) {
        cashRegisterRepositoryDB = new CashRegisterRepositoryDB(connection);
//        System.out.println("CashRegisterRepositoryDB a fost creat");
    }

    public boolean login(String name, int number) throws SQLException {
        auditService.writeData(Thread.currentThread().getName()+ ", login");
        return cashRegisterRepositoryDB.login(name, number);
    }


    public void addCashRegister(CashRegister p) throws SQLException {

        auditService.writeData(Thread.currentThread().getName() + ", addCashRegister");
        cashRegisterRepositoryDB.add(p);
    }


    public void changeNumberOfCashRegister(int number, int newNumber) throws SQLException {
        auditService.writeData(Thread.currentThread().getName() + ", changeNumberOfCashRegister");
        cashRegisterRepositoryDB.changeNumberOfCashRegister(number, newNumber) ;
    }

    public List<CashRegister> getCashRegister() throws SQLException {
        auditService.writeData(Thread.currentThread().getName() + ", getCashRegister");
        return cashRegisterRepositoryDB.getAll();
    }

    public void deleteByNumber(int number) throws SQLException {
        auditService.writeData(Thread.currentThread().getName() + "deleteByNumber");
        cashRegisterRepositoryDB.delete(number);
    }

    public CashRegister findByNumber(int number) throws SQLException {
        auditService.writeData(Thread.currentThread().getName() + ", findByNumber");
        return cashRegisterRepositoryDB.findByNumber(number);
    }
}
