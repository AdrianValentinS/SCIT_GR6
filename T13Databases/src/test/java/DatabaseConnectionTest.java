import org.junit.*;
import static org.junit.Assert.*;

public class DatabaseConnectionTest {

    DatabaseConnection dbcTest = new DatabaseConnection();

    /* Test first asserts that the accumulated executed statement value is 3 (one for each executed statement, each
    having empty result sets), then asserts that the result set from printRoomTypeAndValue contains metadata (is not empty).
     */

    @Test()
    public void insertPrintTest() throws java.sql.SQLException {
        dbcTest.executeCommand("DROP TABLE accomodation_fair_relation;");
        dbcTest.executeCommand("DROP TABLE accomodation;");
        dbcTest.executeCommand("DROP TABLE room_fair;");
        dbcTest.executeCommand("""
                CREATE TABLE accomodation (\s
                \tid INT PRIMARY KEY,
                \ttype VARCHAR(32),
                \tbed_type VARCHAR(32),
                \tmax_guests INT,
                \tdescription VARCHAR(32)
                );""");
        dbcTest.executeCommand("""
                CREATE TABLE room_fair (\s
                \tid INT PRIMARY KEY,
                \tvalue DOUBLE PRECISION,
                \tseason VARCHAR(32)
                );""");
        dbcTest.executeCommand("""
                CREATE TABLE accomodation_fair_relation (\s
                \tid INT NOT NULL PRIMARY KEY,
                \tid_accomodation int,
                \tid_room_fair int,
                \tCONSTRAINT id_accomodation_constraint FOREIGN KEY (id_accomodation) REFERENCES accomodation(id),
                \tCONSTRAINT id_room_fair_constraint FOREIGN KEY (id_room_fair) REFERENCES room_fair(id)
                );""");

        assertEquals(dbcTest.insertIntoTableValues(), 3);
        assertTrue(dbcTest.printRoomTypeAndValue());
    }
}