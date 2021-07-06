import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.rules.TemporaryFolder;
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import java.io.*;

public class MainTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test  // Works with temporary files that don't exist outside of the unit test.
    public void fileParseTest() throws IOException {

        File testFile = folder.newFile("testFile.csv");

        FileWriter fileWriter0 = new java.io.FileWriter(testFile);
        BufferedWriter bufferedWriter0 = new java.io.BufferedWriter(fileWriter0);
        bufferedWriter0.write("""
                3,boris,RU,25:25,xxxox,xxxxx,xxoxo
                2,jinping,KP,30:33,xxoox,xooxo,xxxxo
                1,ryu hayabusa,CN,65:33,xxxxx,xxxxx,xxxxx
                """);
        bufferedWriter0.close();
        List<Athlete> rankingsTest = AthleteManager.copyAthletesFromFile(testFile.toString());
        System.out.println(rankingsTest);

        assertTrue(testFile.exists());
        assertNotNull(rankingsTest);
    }

    @Test
    public void timeCalculatorTest() {
        String testTime = Athlete.timeCalculator(1800);
        assertThat(testTime, containsString("30:0"));
    }

    @Test
    public void skiTimeResultCalculatedTest() {
        int testTime = Athlete.calculatorStringSplitter("30:0");
        assertEquals(testTime, 1800);
    }

    @Test
    public void rangeFailureCalculatorTest() {
        Athlete athleteTest = new Athlete(1, "boris", "ru", "25:25", "xxxox","xxxxx", "xxoxo");
        assertEquals(athleteTest.rangeFailureCalculator(), 30);
    }

    @Test
    public void comparatorTest() {
        Athlete athleteTest0 = new Athlete(1, "b", "ru", "25:25", "xoxox","xoxxx", "xooxo");
        Athlete athleteTest1 = new Athlete(2, "c", "ru", "30:25", "xoxox","xxxox", "oxoxo");
        Athlete athleteTest2 = new Athlete(3, "a", "ru", "20:25", "oxxox","xoxxx", "oxoxo");

        List<Athlete> athleteListTest = new java.util.ArrayList<>();
        athleteListTest.add(athleteTest0);
        athleteListTest.add(athleteTest1);
        athleteListTest.add(athleteTest2);

        Athlete.compareWinnersJava8(athleteListTest);

        boolean containsAthlete0 = athleteListTest.contains(athleteTest0);
        boolean containsAthlete1 = athleteListTest.contains(athleteTest1);
        boolean containsAthlete2 = athleteListTest.contains(athleteTest2);

        assertTrue(containsAthlete0);
        assertTrue(containsAthlete1);
        assertTrue(containsAthlete2);

        int index0 = athleteListTest.indexOf(athleteTest0);
        int index1 = athleteListTest.indexOf(athleteTest1);
        int index2 = athleteListTest.indexOf(athleteTest2);

        assertEquals(0, index2);
        assertEquals(2, index1);
        assertEquals(1, index0);
    }
}