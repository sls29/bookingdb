package bookingApp;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App {

    public static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/bookingdb";
    static final String USER = "postgres";
    static final String PASSWORD = "root";

    public static void main( String[] args ) {

        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            stmt = conn.createStatement();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
