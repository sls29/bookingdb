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

    public static void main( String[] args ) throws Exception {

        Connection conn = null;
       Statement stmt = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            stmt = conn.createStatement();

            String sql = "INSERT INTO accommodation VALUES(?, ?, ?, ?, ?)";

            preparedStatement = conn.prepareStatement(sql);

//            preparedStatement.setInt(1, 1);
//            preparedStatement.setString(2, "apartment");
//            preparedStatement.setString(3, "double bed");
//            preparedStatement.setInt(4, 2);
//            preparedStatement.setString(5, "beach front");
//            preparedStatement.addBatch();
//
//            preparedStatement.setInt(1, 2);
//            preparedStatement.setString(2, "apartment");
//            preparedStatement.setString(3, "queen size bed");
//            preparedStatement.setInt(4, 2);
//            preparedStatement.setString(5, "beach front, AC");
//            preparedStatement.addBatch();

            preparedStatement.setInt(1, 3);
            preparedStatement.setString(2, "penthouse");
            preparedStatement.setString(3, "king size bed");
            preparedStatement.setInt(4, 2);
            preparedStatement.setString(5, "beach front, AC, room service");
            preparedStatement.addBatch();

            int[] updateCounts = preparedStatement.executeBatch();
//            conn.commit();
//            conn.setAutoCommit(true);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
