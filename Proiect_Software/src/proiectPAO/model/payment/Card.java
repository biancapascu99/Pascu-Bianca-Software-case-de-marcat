package proiectPAO.model.payment;

public class Card {

    private String name;
    private int cardNumber;

    public Card(String name, int numberCard) {
        this.name = name;
        this.cardNumber = numberCard;
    }

    public Card() {
        this.name = null;
        this.cardNumber = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberCard() {
        return cardNumber;
    }

    public void setNumberCard(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", cardNumber=**********" + cardNumber +
                '}';
    }
}