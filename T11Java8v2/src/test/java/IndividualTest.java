import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class IndividualTest {

    String filePath = new File("").getAbsolutePath();

    @Before
    public void setUp() throws Exception {
        filePath = filePath.concat("\\src\\main\\resources\\individualsTest.txt");
    }

    @Test
    public void individualListProcessorTest() throws IOException {
        List<Individual> individualList0Test = Individual.getIndividualsFromFile(filePath);
        List<Individual> individualList1Test = Individual.individualListProcessor(individualList0Test, 03);
        Individual.writeIndividualsToFile(individualList1Test, "src\\main\\resources\\individualsProcessedTest.txt");
    }
}