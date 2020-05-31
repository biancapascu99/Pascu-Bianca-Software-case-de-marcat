package proiectPAO.model.payment;

import proiectPAO.model.cashregisters.CashRegister;
import proiectPAO.model.products.Product;

import java.util.List;

public class Payment {

    private int paymentId;
    private List<Product> list;
    private boolean isFidelityCard;
    private CashRegister cashRegister;
    private Card card;
    private static int paymentCount = 0;

    public Payment(List<Product> list, CashRegister cashRegister, boolean isFidelityCard, Card card) {
        this.paymentId = ++paymentCount;
        this.list = list;
        this.isFidelityCard = isFidelityCard;
        this.card = card;
        this.cashRegister = cashRegister;
    }

    public Payment(List<Product> list, CashRegister cashRegister, boolean isFidelityCard) {
        this.paymentId = ++paymentCount;
        this.list = list;
        this.isFidelityCard = isFidelityCard;
        this.cashRegister = cashRegister;
        this.card = null;
    }

    //Daca exista card de fidelitate se face un discount de 0.01
    public double sumList() {
        double sum = 0;
        for (Product prod : list)
            sum = sum + prod.priceQuantity();
        if (isFidelityCard)
            return sum - (sum * 0.01);
        else
            return sum;
    }


    //Afisarea unui bon fiscal cu verificare daca plata se face cu cardul sau cu cash
    @Override
    public String toString() {
        String returnString = "";
        if (this.card != null) {
            returnString += "\n-----Lista produse-----\n";
            for (Product prod : list)
                returnString += "\nNume produs: " + prod.getName() + "....." + "Cantitate: " + prod.getQuantity()
                        + "..........." + "Pret: " + prod.priceQuantity();

            returnString += "\nSuma platita......................................" + sumList();
            returnString += "\n-----Plata a fost facuta cu cardul-----";
            returnString += "\nNume posesor card: " + card.getName();
            returnString += "\nNumar card: ***********" + card.getNumberCard();
            returnString += "\nNR CASA: " + cashRegister.getNumberCashier();
            returnString += "\nData emiterii: " + java.util.Calendar.getInstance().getTime();
        } else {
            returnString += "\n-----Lista produse-----\n";
            for (Product prod : list)
                returnString += "\nNume produs: " + prod.getName() + "....." + "Cantitate: " + prod.getQuantity()
                        + "..........." + "Pret: " + prod.priceQuantity();

            returnString += "\nSuma platita......................................" + sumList();
            returnString += "\n-----Plata a fost facuta cu cash-----";
            returnString += "\nNR CASA: " + cashRegister.getNumberCashier();
        }
        return returnString;
    }


    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public boolean isFidelityCard() {
        return isFidelityCard;
    }

    public void setFidelityCard(boolean fidelityCard) {
        this.isFidelityCard = fidelityCard;
    }

    public CashRegister getCashRegister() {
        return cashRegister;
    }

    public void setCashRegister(CashRegister cashRegister) {
        this.cashRegister = cashRegister;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public static int getPaymentCount() {
        return paymentCount;
    }

    public static void setPaymentCount(int paymentCount) {
        Payment.paymentCount = paymentCount;
    }
}



