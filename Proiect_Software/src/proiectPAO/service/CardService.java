package proiectPAO.service;

import proiectPAO.model.payment.Card;
import proiectPAO.model.products.Product;
import proiectPAO.repository.CardRepository;
import proiectPAO.repository.CashRegisterRepository;

import java.util.List;

public class CardService {
    private static CardService instance = new CardService();
    private CardRepository cardRepository = new CardRepository();
    private AuditService auditService = AuditService.getInstance();

    private CardService() {

//        System.out.println("CardService a fost creat");
    }

    public static CardService getInstance() {
        return instance;
    }

    public void addCard(Card p) {
        auditService.writeData("CardService-addCard");
        cardRepository.add(p);
    }

    public void addCard(List<Card> p) {
        cardRepository.add(p);
    }

    public List<Card> getCard() {
        auditService.writeData("CardService-getCard");
        return cardRepository.getAll();
    }
}
