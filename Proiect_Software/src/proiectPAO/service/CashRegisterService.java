package proiectPAO.service;

import proiectPAO.model.cashregisters.CashRegister;
import proiectPAO.model.payment.Payment;
import proiectPAO.model.products.Product;
import proiectPAO.repository.CashRegisterRepository;
import proiectPAO.repository.PaymentRepository;

import java.util.List;

public class CashRegisterService {
    private static CashRegisterService instance = new CashRegisterService();
    private CashRegisterRepository cashRegisterRepository = new CashRegisterRepository();

    private CashRegisterService() {
        System.out.println("CashRegisterService a fost creat");
    }

    public static CashRegisterService getInstance() {
        return instance;
    }

    public void addCashRegister(CashRegister p) {
        cashRegisterRepository.add(p);
    }

    public void addCashRegister(List<CashRegister> p) {
        cashRegisterRepository.add(p);
    }

    public void changeNumberOfCashRegister(int number, int newNumber) {
        CashRegister p = cashRegisterRepository.findByNumber(number);
        p.setCashierNumber(newNumber);
    }

    public List<CashRegister> getCashRegister() {
        return cashRegisterRepository.getAll();
    }

    public void deleteByNumber(int number) {
        cashRegisterRepository.delete(number);
    }

    public CashRegister findByNumber(int number) {
        return cashRegisterRepository.findByNumber(number);
    }

}
