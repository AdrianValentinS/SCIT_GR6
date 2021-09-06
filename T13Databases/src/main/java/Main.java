import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        DatabaseConnection dbcObject = new DatabaseConnection();
        dbcObject.insertIntoTableValues();
        dbcObject.printRoomTypeAndValue();

    }
}
