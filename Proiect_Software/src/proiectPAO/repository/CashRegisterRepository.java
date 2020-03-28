package proiectPAO.repository;

import proiectPAO.model.cashregisters.CashRegister;

import java.util.ArrayList;
import java.util.List;

public class CashRegisterRepository {

    private List<CashRegister> cashRegisterList = new ArrayList<>();

    public void add(CashRegister cashRegister) {
        cashRegisterList.add(cashRegister);
    }

    public void add(List<CashRegister> cashRegisters) {
        cashRegisterList.addAll(cashRegisters);
    }

    public CashRegister findByNumber(int cashRegisterNumber) {
        for (CashRegister cashRegister : cashRegisterList) {
            if (cashRegister != null) {
                if (cashRegisterNumber == cashRegister.getNumberCashier())
                    return cashRegister;
            }
        }
        return null;
    }

    public List<CashRegister> getAll() {
        return cashRegisterList;
    }

    public void delete(int cashRegisterNumber) {
        cashRegisterList.removeIf(c -> c.getNumberCashier() == cashRegisterNumber);
    }

}
