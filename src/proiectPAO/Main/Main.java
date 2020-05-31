package proiectPAO.Main;

import proiectPAO.BD.DbConnectionUtil;
import proiectPAO.model.cashregisters.CashRegister;
import proiectPAO.model.payment.Card;
import proiectPAO.model.payment.Payment;
import proiectPAO.model.products.*;
import proiectPAO.repository.FoodProductRepositoryDB;
import proiectPAO.service.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Product> productList = new ArrayList<>();
    private static List<Payment> paymentList = new ArrayList<>();
    private static List<CashRegister> cashRegisterList = new ArrayList<>();
    private static List<Card> cardList = new ArrayList<>();

    private static CashRegisterService cashRegisterService = CashRegisterService.getInstance();
    private static PaymentService paymentService = PaymentService.getInstance();
    private static ProductService productService = ProductService.getInstance();
    private static CardService cardService = CardService.getInstance();

    private static CardCSVService cardCSVService = CardCSVService.getInstance();
    private static CashRegisterCSVService cashRegisterCSVService = CashRegisterCSVService.getInstance();
    private static FoodProductCSVService foodProductCSVService = FoodProductCSVService.getInstance();
    private static CleaningProductCSVService cleaningProductCSVService = CleaningProductCSVService.getInstance();
    private static FurnitureProductCSVService furnitureProductCSVService = FurnitureProductCSVService.getInstance();
    private static AppliancesProductCSVService appliancesProductCSVService = AppliancesProductCSVService.getInstance();
    private static ClotheProductCSVService clotheProductCSVService = ClotheProductCSVService.getInstance();

//    private static CashRegisterService cashRegisterServiceDB = CashRegisterService.getInstance();
//    private static PaymentService paymentServiceDB = PaymentService.getInstance();
//    private static ProductService productServiceDB = ProductService.getInstance();

    private static Connection connection = DbConnectionUtil.getDBConnection();
    private static CardServiceDB cardServiceDB = new CardServiceDB(connection);
    private static CashRegisterServiceDB cashRegisterServiceDB = new CashRegisterServiceDB(connection);


    //    Etapa I
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

    public static void etapaI() {
        createLists();

        //Product

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

        cashRegisterService.addCashRegister(cashRegisterList);
        System.out.println(cashRegisterService.getCashRegister());
        System.out.println("\nCasa cu numarul 7 a fost schimbata in casa cu numarul 6.");
        cashRegisterService.changeNumberOfCashRegister(7, 6);
        System.out.println(cashRegisterService.getCashRegister());

        //Card

        cardService.addCard(cardList);
        System.out.println("\nLista cardurilor; ");
        System.out.println(cardService.getCard());
    }

    //    EtapaII
    public static void loadData() {
        cardCSVService.readData();
        cashRegisterCSVService.readData();
        foodProductCSVService.readData();
        furnitureProductCSVService.readData();
        cleaningProductCSVService.readData();
        clotheProductCSVService.readData();
        appliancesProductCSVService.readData();
    }

    public static void etapaII() {

        loadData();

        System.out.println("Lista produselor");
        System.out.println(productService.getProducts());

        System.out.println("\nLista caselor");
        System.out.println(cashRegisterService.getCashRegister());

        System.out.println("\nLista cardurilor; ");
        System.out.println(cardService.getCard());

    }

    //  Etapa III

    public static void etapaIII() throws SQLException {

//        card

//        Card card1 = new Card();
//        card1.setName("Miana");
//        card1.setNumberCard(8345);
//        cardServiceDB.addCard(card1);
//        Card card2 = new Card();
//        card2.setName("Mirel");
//        card2.setNumberCard(2452);
//        cardServiceDB.addCard(card2);
//        System.out.println(cardServiceDB.getCard());
//        cardServiceDB.deleteCard(2452);
//        System.out.println(cardServiceDB.getCard());

//        cashRegister

        CashRegister cashRegister1 = new CashRegister();
        cashRegister1.setCashierNumber(5);
        cashRegister1.setCashierName("Mara");
        cashRegisterServiceDB.addCashRegister(cashRegister1);
        CashRegister cashRegister2 = new CashRegister();
        cashRegister2.setCashierNumber(14);
        cashRegister2.setCashierName("Mirela");
        cashRegisterServiceDB.addCashRegister(cashRegister2);
        System.out.println(cashRegisterServiceDB.getCashRegister());
//        cashRegisterServiceDB.deleteByNumber(14);
//        cashRegisterServiceDB.deleteByNumber(13);
//        System.out.println(cashRegisterServiceDB.getCashRegister());
//        System.out.println(cashRegisterServiceDB.findByNumber(12));
        cashRegisterServiceDB.changeNumberOfCashRegister(5, 45);
        System.out.println(cashRegisterServiceDB.getCashRegister());


    }


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//        etapaI();
//        System.out.println("__________ETAPA_II____________");
//        etapaII();


        //etapa3
        //-------------------------cashregister-------------------------
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connection = DbConnectionUtil.getDBConnection();
//        CashRegisterRepositoryDB cashRegisterRepositoryDB = new CashRegisterRepositoryDB(connection);
//
//        CashRegister cashRegister = new CashRegister();
//        cashRegister.setCashierNumber(5);
//        cashRegister.setCashierName("Mara");
//        cashRegisterRepositoryDB.add(cashRegister);
//        cashRegister.setCashierNumber(12);
//        cashRegister.setCashierName("Mara");
//        cashRegisterRepositoryDB.add(cashRegister);
//        System.out.println(cashRegisterRepositoryDB.getAll());
//        cashRegisterRepositoryDB.delete(5);
//        cashRegisterRepositoryDB.delete(12);
//        System.out.println(cashRegisterRepositoryDB.getAll());
//        System.out.println(cashRegisterRepositoryDB.findByNumber(12));


        //-------------------------product furniture-------------------------------

//        FurnitureProductRepositoryBD furnitureProductRepositoryBD = new FurnitureProductRepositoryBD(connection);
//        FurnitureProduct furnitureProduct = new FurnitureProduct();
//        furnitureProduct.setName("scaun");
//        furnitureProduct.setPrice(20);
//        furnitureProduct.setQuantity(2);
//        furnitureProduct.setDiscount(1);
//       furnitureProduct.setHasGuarantee(true);
//        furnitureProduct.setPriceTransport(0);
//        furnitureProductRepositoryBD.add(furnitureProduct);
//        furnitureProduct.setName("masa");
//        furnitureProduct.setPrice(20);
//        furnitureProduct.setQuantity(2);
//        furnitureProduct.setDiscount(1);
//        furnitureProduct.setHasGuarantee(false);
//        furnitureProduct.setPriceTransport(2.0);
//        furnitureProductRepositoryBD.add(furnitureProduct);
////        furnitureProductRepositoryBD.delete("scaun");
////        furnitureProductRepositoryBD.delete("masa");
//
////        System.out.println(furnitureProductRepositoryBD.findByGuarantee());
////        System.out.println(furnitureProductRepositoryBD.findByTransport());
////        System.out.println(furnitureProductRepositoryBD.getAll());
//        System.out.println(furnitureProductRepositoryBD.findByName("masa"));

//----------------------product food-----------------------------

//        FoodProductRepositoryDB foodProductRepositoryDB = new FoodProductRepositoryDB(connection);
//        FoodProduct foodProduct = new FoodProduct();
//        foodProduct.setName("mar");
//        foodProduct.setPrice(15.20);
//        foodProduct.setQuantity(3);
//        foodProduct.setDiscount(0.1);
//        foodProduct.setExpired(false);
//        foodProductRepositoryDB.add(foodProduct);
//        foodProduct.setName("pere");
//        foodProduct.setPrice(10.20);
//        foodProduct.setQuantity(2);
//        foodProduct.setDiscount(0);
//        foodProduct.setExpired(true);
//        foodProductRepositoryDB.add(foodProduct);
//        System.out.println(foodProductRepositoryDB.getAll());
////        foodProductRepositoryDB.delete("mar");
////        System.out.println(foodProductRepositoryDB.getAll());
//        System.out.println(foodProductRepositoryDB.findByName("pere"));
////        System.out.println(foodProductRepositoryDB.findByExpired());

        etapaIII();


    }
}


