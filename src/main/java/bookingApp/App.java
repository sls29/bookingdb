package bookingApp;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App {



    public static void main( String[] args ) throws Exception {

        Database data = new Database();
        data.Connect();

        Accommodation roomA = new Accommodation("apartment", "double bed",
                2, "front beach");


//       Statement stmt = null;
//        PreparedStatement preparedStatement = null;
//
//
//            stmt = conn.createStatement();
//
//            String sql = "INSERT INTO accommodation VALUES(?, ?, ?, ?, ?)";
//
//            preparedStatement = conn.prepareStatement(sql);

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

//            preparedStatement.setInt(1, 3);
//            preparedStatement.setString(2, "penthouse");
//            preparedStatement.setString(3, "king size bed");
//            preparedStatement.setInt(4, 2);
//            preparedStatement.setString(5, "beach front, AC, room service");
//            preparedStatement.addBatch();
//
//            int[] updateCounts = preparedStatement.executeBatch();
//            conn.commit();
//            conn.setAutoCommit(true);




    }
}
