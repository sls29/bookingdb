package bookingApp;

import java.sql.*;

public class Database {
    public static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/bookingdb";
    static final String USER = "postgres";
    static final String PASSWORD = "root";

    public int accId;
    public int roomFairId;


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
            preparedStatement.addBatch();

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

    public void setPrice(String roomType, RoomFair price){
        Connection conn = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Database -> connected");


            try {
                PreparedStatement psRoomFair = null;

                String sql0 = "INSERT INTO room_fair (value, season) " +
                        "VALUES(?, ?)";
                psRoomFair = conn.prepareStatement(sql0);
                psRoomFair.setDouble(1, price.value);
                psRoomFair.setString(2, String.valueOf(price.season));
                psRoomFair.addBatch();

                psRoomFair.executeUpdate();
                ResultSet rs0 = psRoomFair.getGeneratedKeys();
                while (rs0.next()) {
                    price.id = rs0.getInt(1);
                }
            } catch (SQLException e0) {
                System.out.println("Error0: " + e0.getMessage());
            }

            try {
                PreparedStatement psAcc = null;

                String sql1 = "SELECT id FROM accommodation WHERE type LIKE ?";
                psAcc = conn.prepareStatement(sql1);
                psAcc.setString(1, roomType);
                ResultSet rs1 = psAcc.executeQuery();
                while (rs1.next()) {
                    accId = rs1.getInt(1);
                }
            } catch (SQLException e1) {
                System.out.println("Error1: " + e1.getMessage() );
            }

            try {
                PreparedStatement psAccRoomFairRelation = null;

                String sql2 = "INSERT INTO accommodation_room_fair_relation " +
                        "(accommodation_id, room_fair_id) VALUES(?, ?)";
                psAccRoomFairRelation = conn.prepareStatement(sql2);
                psAccRoomFairRelation.setInt(1, accId);
                psAccRoomFairRelation.setInt(2, price.id);
                psAccRoomFairRelation.addBatch();

                ResultSet rs2 = psAccRoomFairRelation.executeQuery();
            } catch (SQLException e2) {
                System.out.println(" Error2: " + e2.getMessage());
            }

            System.out.println("- Room fair added.");

            conn.close();
            System.out.println("Database -> connection terminated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateRoom() {

    }

    public void updatePrice(){

    }

}
