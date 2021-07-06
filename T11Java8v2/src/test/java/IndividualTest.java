import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class IndividualTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test // Works with temporary files that don't exist outside of the unit test.
    public void fileParseTest() throws IOException {

        File testFile = folder.newFile("individualsTest.txt");

        FileWriter fileWriter0 = new java.io.FileWriter(testFile);
        BufferedWriter bufferedWriter0 = new java.io.BufferedWriter(fileWriter0);
        bufferedWriter0.write("""
            Gabriel Hunt 1978-03-23
            Alex Lee 1966-03-12
            Kyle Burke 1934-03-26
            Leon Hayes 1945-07-02
            Blake Matthews 1987-03-04
            Talon Hunter 1947-05-08
                """);
        bufferedWriter0.close();
        List<Individual> individualList0 = Individual.getIndividualsFromFile(testFile.toString());
        System.out.println(individualList0);

        assertTrue(testFile.exists());
        assertNotNull(individualList0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void monthTest() {
        Individual individualTest = new Individual();
        individualTest.monthChecker(13);
    }

    @Test
    public void monthExtractorTest() {
        Individual individualTest = new Individual("Gabriel", "Hunt", "1978-03-23");
        individualTest.extractMonthFromBirthDate();
        assertEquals(individualTest.getBirthDateMonth(),03);
    }

    @Test
    public void processorTest() {
        Individual individualTest0 = new Individual("c", "c", "1978-05-23");
        Individual individualTest1 = new Individual("b", "b", "1978-05-23");
        Individual individualTest2= new Individual("a", "a", "1978-05-23");

        List<Individual> individualListTest = new java.util.ArrayList<>();
        individualListTest.add(individualTest0);
        individualListTest.add(individualTest1);
        individualListTest.add(individualTest2);

        System.out.println(Individual.individualListProcessor(individualListTest, 05));

        boolean containsIndividual0 = individualListTest.contains(individualTest0);
        boolean containsIndividual1 = individualListTest.contains(individualTest1);
        boolean containsIndividual2 = individualListTest.contains(individualTest2);

        assertTrue(containsIndividual0);
        assertTrue(containsIndividual1);
        assertTrue(containsIndividual2);

        int index0 = individualListTest.indexOf(individualTest0);
        int index1 = individualListTest.indexOf(individualTest1);
        int index2 = individualListTest.indexOf(individualTest2);

        assertEquals(2, index2);
        assertEquals(1, index1);
        assertEquals(0, index0);
    }

    @Test // Works with temporary files that don't exist outside of the unit test.
    public void writeIndividualsTest() throws java.io.IOException {

        File testFile = folder.newFile("individualsTest.txt");

        Individual individualTest0 = new Individual("c", "c", "1978-05-23");
        Individual individualTest1 = new Individual("b", "b", "1978-05-23");
        Individual individualTest2= new Individual("a", "a", "1978-05-23");

        List<Individual> individualListTest = new java.util.ArrayList<>();
        individualListTest.add(individualTest0);
        individualListTest.add(individualTest1);
        individualListTest.add(individualTest2);

        Individual.writeIndividualsToFile(individualListTest, testFile.getAbsolutePath());

        assertTrue(testFile.exists());

        System.out.println(testFile.toString());

    }
}