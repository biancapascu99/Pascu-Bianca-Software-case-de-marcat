package proiectPAO.service;

import proiectPAO.model.payment.Payment;
import proiectPAO.model.products.Product;
import proiectPAO.repository.PaymentRepository;

import java.util.List;

public class PaymentService {

    private static PaymentService instance = new PaymentService();
    private PaymentRepository paymentRepository = new PaymentRepository();
    private AuditService auditService = AuditService.getInstance();

    private PaymentService() {
//        System.out.println("PaymentService a fost creat");
    }

    public static PaymentService getInstance() {
        return instance;
    }

    public void addPayment(Payment p) {
        auditService.writeData("PaymentService-addPayment");
        paymentRepository.add(p);
    }

    public void addProduct(List<Payment> p) {
        paymentRepository.add(p);
    }

    public List<Payment> getPayments() {
        auditService.writeData("PaymentService-getPayment");
        return paymentRepository.getAll();
    }

    //bonurile eliberate de casa cu numarul 'number'
    public List<Payment> getByCashRegister(int number) {
        auditService.writeData("PaymentService-getByCashRegister");
        return paymentRepository.findByCashRegisterNumber(number);
    }

    //bonurile platite cu cardul
    public List<Payment> getByPaymentCard() {
        auditService.writeData("PaymentService-getByPaymentCard");
        return paymentRepository.getPaymentCard();
    }

    //bonurile platite cash
    public List<Payment> getByPaymentCash() {
        auditService.writeData("PaymentService-getByPaymentCash");
        return paymentRepository.getPaymentCash();
    }

    public void deleteById(int id) {
        auditService.writeData("PaymentService-deleteById");
        paymentRepository.delete(id);
    }

    public Payment findById(int id) {
        auditService.writeData("PaymentService-findById");
        return paymentRepository.findById(id);
    }
}
