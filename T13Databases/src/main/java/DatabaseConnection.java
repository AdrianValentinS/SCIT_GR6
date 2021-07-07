import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {

/**
 * Establishes connection with database.
 * @return Database connection instance, used for database interaction.
 * @throws SQLException in case of connection failure.
 */

private Connection getConnection() throws SQLException {
    try {

        Class.forName("org.postgresql.Driver");

        DriverManager.setLoginTimeout(60);

    } catch (ClassNotFoundException e) {
        System.err.println("No definition for the class with the specified name could be found.");
    }

    String connectionUrl = "jdbc:postgresql://localhost:5432/bookingAppDB";
    String user = "postgres";
    String password = "password";

    System.out.println("Connection to database established.");

    return DriverManager.getConnection(connectionUrl, user, password);
}

/**
 * Takes in a connection and executes a series of prepared statements, closes each statement after execution, then closes the connection.
 */

public int insertIntoTableValues() throws SQLException {
    int statementExecutionAccumulator = 0;
    Connection connection0 = getConnection();
        PreparedStatement pStatement0 = connection0.prepareStatement("INSERT INTO accomodation(id, type, bed_type, max_guests, description) VALUES (?, ?, ?, ?, ?)");
        pStatement0.setInt(1, 1);
        pStatement0.setString(2, "Sample Room");
        pStatement0.setString(3, "Sample Bed");
        pStatement0.setInt(4, 2);
        pStatement0.setString(5, "Sample Quality");
        if (!pStatement0.execute()) {
            statementExecutionAccumulator++;
        }
        System.out.println("Prepared statement 0 executed. Number of statements executed: " + statementExecutionAccumulator);
        pStatement0.close();
        System.out.println("Prepared statement 0 closed.");
        PreparedStatement pStatement1 = connection0.prepareStatement("INSERT INTO room_fair(id, value, season) VALUES (?, ?, ?)");
        pStatement1.setInt(1,1);
        pStatement1.setDouble(2, 99.99);
        pStatement1.setString(3, "Sample Season");
        if (!pStatement1.execute()) {
        statementExecutionAccumulator++;
        }
        System.out.println("Prepared statement 1 executed. Number of statements executed: " + statementExecutionAccumulator);
        pStatement1.close();
        System.out.println("Prepared statement 1 closed.");
        PreparedStatement pStatement2 = connection0.prepareStatement("INSERT INTO accomodation_fair_relation(id, id_accomodation, id_room_fair) VALUES (?, ?, ?)");
        pStatement2.setInt(1, 1);
        pStatement2.setInt(2, 1);
        pStatement2.setInt(3, 1);
        if (!pStatement2.execute()) {
        statementExecutionAccumulator++;
        }
        System.out.println("Prepared statement 2 executed. Number of statements executed: " + statementExecutionAccumulator);
        pStatement2.close();
        System.out.println("Prepared statement 2 closed.");

    return statementExecutionAccumulator;
}

/**
 * Connects, executes a prepared statement which inner joins all tables and uses a while + for loop to print each
 * column name and value from the resultSet.
 */

public boolean printRoomTypeAndValue() throws SQLException {

    Connection connection0;
    PreparedStatement pStatement0;
    ResultSet resultSet0;

    connection0 = getConnection();

    pStatement0 = connection0.prepareStatement("""
            SELECT type, value FROM accomodation_fair_relation\s
            INNER JOIN accomodation ON accomodation_fair_relation.id_accomodation = accomodation.id\s
            INNER JOIN room_fair ON accomodation_fair_relation.id_room_fair = room_fair.id;""".indent(1));

    resultSet0 = pStatement0.executeQuery();

    System.out.println("Printing statement executed. Room cost in euros:");

    ResultSetMetaData rsmd = resultSet0.getMetaData();

    int columnsNumber = rsmd.getColumnCount();

    while (resultSet0.next()) {
        for (int i = 1; i <= columnsNumber; i++) {
            String columnValue = resultSet0.getString(i);
            System.out.println(rsmd.getColumnName(i) + " " + columnValue);
        }
        System.out.println("");
    }
    boolean resultSetContainsData = false;
    if(resultSet0.getMetaData() != null){
        resultSetContainsData = true;
        pStatement0.close();
        System.out.println("Printing statement closed.");
        connection0.close();
        System.out.println("Connection ended with database.");
    }
    return resultSetContainsData;
}

/**
 * Small method that executes a single SQL command by parameter input.
 * @param sqlCommand SQL command to be executed.
 */

public void executeCommand(String sqlCommand) {
    try (Connection connection0 = getConnection()) {
        Statement statement0 = connection0.createStatement();
        statement0.executeUpdate(sqlCommand); // Not executeQuery because executeQuery expects a resultset/results. Update expects nothing.
        System.out.println("Command " + sqlCommand + " executed.");
        statement0.close();
        System.out.println("Statement closed.");
        connection0.close();
        System.out.println("Connection closed.");
    } catch (SQLException throwable) {
        throwable.printStackTrace();
    }
}
}