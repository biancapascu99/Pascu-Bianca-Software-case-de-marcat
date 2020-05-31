package proiectPAO.BD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionUtil {

    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/SCDM";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "bianca199925@";

    public static Connection getDBConnection()  {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static void closeDBConnection(Connection connection)  {
        try {
            if(connection != null) {
                connection.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}