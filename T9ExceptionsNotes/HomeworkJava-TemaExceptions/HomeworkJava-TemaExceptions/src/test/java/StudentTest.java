import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void verifyYear() throws Validation {
        Student student = new Student("Ion","Vasile", "1899" , 232312312, "m");
    }

    @Test
    void verifyEmpty() throws Validation {
        Student student = new Student("","Vasile", "1899" , 232312312, "m");
    }

    @Test
    void verifyUpperLower() throws Validation {
        Student student = new Student("Ion","Vasile", "1899" , 232312312, "mF");
    }
}