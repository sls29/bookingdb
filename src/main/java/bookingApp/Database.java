package bookingApp;

import java.sql.*;

public class Database {
    public static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/bookingdb";
    static final String USER = "postgres";
    static final String PASSWORD = "root";

    public void addNewRoom(Accommodation room) {
        long id = 0;
        Connection conn = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Database -> connected");

            PreparedStatement preparedStatement = null;

            String sql = "INSERT INTO accommodation (type, bed_type, max_guests, description) " +
                    "VALUES(?, ?, ?, ?)";

            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, room.roomType);
            preparedStatement.setString(2, room.bedType);
            preparedStatement.setInt(3, room.maxGuest);
            preparedStatement.setString(4, room.roomDescription);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                    if(rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println(id);
            }

            System.out.println("- Room added.");

            conn.close();
            System.out.println("Database -> connection terminated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addRoom() {

    }
}
