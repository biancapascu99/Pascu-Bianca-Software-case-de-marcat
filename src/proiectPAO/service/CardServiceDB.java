package proiectPAO.service;

import proiectPAO.BD.DbConnectionUtil;
import proiectPAO.model.payment.Card;
import proiectPAO.repository.CardRepositoryDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CardServiceDB {

    private CardRepositoryDB cardRepositoryDB;

    public CardServiceDB(Connection connection) {
        cardRepositoryDB = new CardRepositoryDB(connection);
//        System.out.println("CardServiceDB a fost creat");
    }


    public void addCard(Card p) throws SQLException {
        cardRepositoryDB.add(p);
    }

    public void deleteCard(int number) throws SQLException {
        cardRepositoryDB.delete(number);
    }

    public List<Card> getCard() throws SQLException {

        return cardRepositoryDB.getAll();
    }
}
