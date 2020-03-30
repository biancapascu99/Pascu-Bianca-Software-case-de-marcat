package proiectPAO.Main;

import proiectPAO.model.cashregisters.CashRegister;
import proiectPAO.model.payment.Card;
import proiectPAO.model.payment.Payment;
import proiectPAO.model.products.*;
import proiectPAO.repository.ProductRepository;
import proiectPAO.service.CardService;
import proiectPAO.service.CashRegisterService;
import proiectPAO.service.PaymentService;
import proiectPAO.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Product> productList = new ArrayList<>();
    private static List<Payment> paymentList = new ArrayList<>();
    private static List<CashRegister> cashRegisterList = new ArrayList<>();
    private static List<Card> cardList = new ArrayList<>();

    private static void createLists() {

        productList.add(new FoodProduct("oua", 30, 10, true));
        productList.add(new FoodProduct("branza", 20, 1.4));
        productList.add(new AppliancesProduct("frigider", 230, 4.5, true, 20));
        productList.add(new FurnitureProduct("scaun", 30, 4.5));
        productList.add(new CleaningProduct("spirt", 12.2, 2, false));
        productList.add(new ClotheProduct("bluza", 21.9, 1, 0, false));

        cashRegisterList.add(new CashRegister("Mirela", 5));
        cashRegisterList.add(new CashRegister("Marin", 7));

        cardList.add(new Card("Nicolae", 231));
        cardList.add(new Card("Iulian", 675));

        List<Product> listPayment1 = new ArrayList<>();
        List<Product> listPayment2 = new ArrayList<>();
        List<Product> listPayment3 = new ArrayList<>();

        listPayment1.add(new FoodProduct("rosii", 15.22, 3, 0.3));
        listPayment1.add(new ClotheProduct("pantaloni", 22.56, 2, 0, true));
        listPayment1.add(new AppliancesProduct("frigider", 267, 1, 0, true, 35.99));

        listPayment2.add(new FurnitureProduct("scaun", 24, 6, 0.04, false, 25));

        listPayment3.add(new FoodProduct("mere", 12.22, 4, 0));
        listPayment3.add(new CleaningProduct("sapun", 32, 2, 0.3));

        paymentList.add(new Payment(listPayment1, cashRegisterList.get(0), true, cardList.get(0)));
        paymentList.add(new Payment(listPayment2, cashRegisterList.get(1), false));
        paymentList.add(new Payment(productList, cashRegisterList.get(0), true));
        paymentList.add(new Payment(listPayment3, cashRegisterList.get(0), false, cardList.get(1)));

    }


    public static void main(String[] args) {

        createLists();

        //Product

        ProductService productService = ProductService.getInstance();
        productService.addProduct(productList);

        System.out.println("Lista produselor");
        System.out.println(productService.getProducts());
        productService.changePriceOfProduct("branza", 80, 0);

        System.out.println("\nPretul produsului branza a fost schimbat.");
        System.out.println(productService.getProducts());

        System.out.println("\nProdusele espirate sunt:");
        System.out.println(productService.getExpired());

        System.out.println("\nProdusele care au garantie sunt:");
        System.out.println(productService.getGuarantee());

        System.out.println("\nProdusele care trebuie livrate sunt:");
        System.out.println(productService.getTransported());

        productService.deleteByName("oua");
        System.out.println("\nProdusul oua a fost sters.");

        System.out.println(productService.getProducts());
        System.out.println(productService.findByName("branza"));

        //Payment

        PaymentService paymentService = PaymentService.getInstance();
        paymentService.addProduct(paymentList);

        System.out.println("\nBonurile emise de casa cu numarul 5:");
        System.out.println(paymentService.getByCashRegister(5));

        System.out.println("\nBonurile emise de casa cu numarul 7:");
        System.out.println(paymentService.getByCashRegister(7));

        System.out.println("\nBonurile platire cu cardul: ");
        System.out.println(paymentService.getByPaymentCard());
        System.out.println("\nBonurile platire cu cash: ");
        System.out.println(paymentService.getByPaymentCash());
        System.out.println("\nBonul cu id 3");
        System.out.println(paymentService.findById(3));

        //CashRegister

        CashRegisterService cashRegisterService = CashRegisterService.getInstance();
        cashRegisterService.addCashRegister(cashRegisterList);
        System.out.println(cashRegisterService.getCashRegister());
        System.out.println("\nCasa cu numarul 7 a fost schimbata in casa cu numarul 6.");
        cashRegisterService.changeNumberOfCashRegister(7, 6);
        System.out.println(cashRegisterService.getCashRegister());

        //Card

        CardService cardService = CardService.getInstance();
        cardService.addCard(cardList);
        System.out.println("\nLista cardurilor; ");
        System.out.println(cardService.getCard());

    }
}


