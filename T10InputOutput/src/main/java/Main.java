import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        // Main class loads athlete data from a CSV file using getAbsolutePath (makes the program platform-agnostic).

        String filepath = new File("").getAbsolutePath();
        filepath = filepath.concat("\\src\\main\\resources\\rankings.csv");

        List<Athlete> rankings0 = AthleteManager.copyAthletesFromFile(filepath);

        // Uses multiple methods to sort the athletes by rank.

        Athlete.compareWinnersJava8(rankings0);

    }
}
