import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AthleteManager {

    /**
     * This method reads CSV files from a specific file path, processes each field by comma ',' into an Athlete class object, then into a list of Athlete objects.
     * @param fileName The file to be processed.
     * @return Returns an arraylist of Athlete objects.
     * @throws IOException if there is no file to process.
     */

    public static List<Athlete> copyAthletesFromFile(String fileName) throws IOException {

        List<Athlete> athleteList = new ArrayList<Athlete>();

        try (BufferedReader bReader0 = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = bReader0.readLine()) != null) {
                String[] athleteFields = line.split(",");
                athleteList.add(new Athlete(Integer.parseInt(athleteFields[0]), athleteFields[1], athleteFields[2], athleteFields[3], athleteFields[4], athleteFields[5], athleteFields[6]));
            }
        }
        return athleteList;
    }
}