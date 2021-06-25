import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void main() throws IOException {

        // Simple test that parses a different rankings file.

        String filepath = new File("").getAbsolutePath();
        filepath = filepath.concat("\\src\\main\\resources\\testRankings.csv");

        List<Athlete> rankingsTest = AthleteManager.copyAthletesFromFile(filepath);

        Athlete.compareWinnersJava8(rankingsTest);


    }
}