package proiectPAO.model.cashregisters;

public class CashRegister {

    private String cashierName;
    private int cashierNumber;

    public CashRegister(String cashier, int numberCashier) {
        this.cashierName = cashier;
        this.cashierNumber = numberCashier;
    }

    public CashRegister() {
        this.cashierName = null;
        this.cashierNumber = 0;
    }

    @Override
    public String toString() {
        return "CashRegister{" +
                "cashier='" + cashierName + '\'' +
                ", numberCashier=" + cashierNumber +
                "\n";
    }

    public int getNumberCashier() {

        return this.cashierNumber;
    }

    public String getCashierName() {

        return this.cashierName;
    }

    public void setCashierName(String cashier) {
        this.cashierName = cashier;
    }

    public void setCashierNumber(int numberCashier) {
        this.cashierNumber = numberCashier;
    }
}
