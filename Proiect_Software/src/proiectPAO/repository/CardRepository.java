package proiectPAO.repository;

import proiectPAO.model.payment.Card;

import java.util.ArrayList;
import java.util.List;

public class CardRepository {

    private List<Card> cardList = new ArrayList<>();

    public void add(Card card) {
        cardList.add(card);
    }

    public void add(List<Card> cards) {
        cardList.addAll(cards);
    }

    public Card findByCardNumber(int cardNumber) {
        for (Card c : cardList) {
            if (c != null) {
                if (cardNumber == c.getNumberCard())
                    return c;
            }
        }
        return null;
    }

    public List<Card> getAll() {
        return cardList;
    }

    public void delete(int cardNumber) {
        cardList.removeIf(c -> c.getNumberCard() == cardNumber);
    }
}
