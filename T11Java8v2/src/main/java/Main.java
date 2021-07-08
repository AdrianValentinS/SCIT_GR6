import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        /*
        Main class concatenates the relative filePath, loads data from a txt file,
        interprets data as objects, adds it to a list and sorts the list according to the
        individualListProcessor method, using streams primarily.
         */

        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("\\src\\main\\resources\\individuals.txt");

        Individual individualObject = new Individual();

        List<Individual> individualList0 = individualObject.getIndividualsFromFile(filePath);
        List<Individual> individualList1 = individualObject.individualListProcessor(individualList0, 2);
        individualObject.writeIndividualsToFile(individualList1, "src\\main\\resources\\individualsProcessed.txt");

    }
}
