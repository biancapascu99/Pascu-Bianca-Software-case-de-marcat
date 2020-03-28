package proiectPAO.repository;

import proiectPAO.model.payment.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentRepository {

    private List<Payment> paymentList = new ArrayList<>();

    public void add(Payment payment) {
        paymentList.add(payment);
    }

    public void add(List<Payment> payments) {
        paymentList.addAll(payments);
    }

    public Payment findById(int id) {
        for (Payment p : paymentList) {
            if (p != null) {
                if (id == p.getPaymentId())
                    return p;
            }
        }
        return null;
    }

    public List<Payment> getAll() {
        return paymentList;
    }

    public void delete(int id) {
        paymentList.removeIf(i -> i.getPaymentId() == id);
    }

    public List<Payment> findByCashRegisterNumber(int number) {
        List<Payment> paymentsCashRegisterNumber = new ArrayList<>();
        for (Payment payment : paymentList)
            if (payment.getCashRegister().getNumberCashier() == number)
                paymentsCashRegisterNumber.add(payment);

        return paymentsCashRegisterNumber;
    }

    public List<Payment> getPaymentCard() {
        List<Payment> paymentsCard = new ArrayList<>();
        for (Payment payment : paymentList)
            if (payment.getCard() != null)
                paymentsCard.add(payment);

        return paymentsCard;
    }

    public List<Payment> getPaymentCash() {
        List<Payment> paymentsCash = new ArrayList<>();
        for (Payment payment : paymentList)
            if (payment.getCard() == null)
                paymentsCash.add(payment);

        return paymentsCash;
    }


}
