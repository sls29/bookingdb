package bookingApp;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App {



    public static void main( String[] args ) throws Exception {

    Database data = new Database();

    data.addNewRoom(new Accommodation("apartmentA",
            "double bed",4, "alley front"));

    data.addNewRoom(new Accommodation("apartmentB",
            "queen size bed",2, "beach front"));

    data.addNewRoom(new Accommodation("apartmentC",
            "king size bed",2, "beach front, AC"));

    data.setPrice("apartmentA", new RoomFair(25, Season.SUMMER));

    data.setPrice("apartmentB", new RoomFair(35, Season.WINTER));
    }
}
