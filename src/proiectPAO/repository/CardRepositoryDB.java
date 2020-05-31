package proiectPAO.repository;

import proiectPAO.model.payment.Card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardRepositoryDB {

    public final Connection connection;

    public CardRepositoryDB(Connection connection) {
        this.connection = connection;
    }

    public void add(Card card) throws SQLException {
        String sql = "INSERT INTO card VALUES (NULL, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, card.getName());
        statement.setInt(2, card.getNumberCard());

        statement.executeUpdate();
        statement.close();
    }

    public void delete(int numberCard) throws SQLException {
        String sqlDelete = "DELETE FROM card WHERE numberCard = ?";
        PreparedStatement statement = connection.prepareStatement(sqlDelete);
        statement.setInt(1, numberCard);
        statement.executeUpdate();
    }


    public List<Card> getAll() throws SQLException {
        List<Card> cards = new ArrayList<Card>();

        String sql = "SELECT * FROM card";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Card a = new Card(rs.getString(2),
                    rs.getInt(3));
            cards.add(a);
        }
        return cards;
    }

}
