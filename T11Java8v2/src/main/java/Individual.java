import lombok.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data

public class Individual {

    private String firstName;
    private String lastName;
    private String birthDate;
    private int birthDateMonth;

    public Individual(String firstName, String lastName, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    /**
     * Processes a list of objects according to the month provided by the object's age field, then by name.
     * @param individualListTemp The list to be processed.
     * @param month The month by which to sort entries.
     * @return A new list for writing into a text file.
     */

    public List<Individual> individualListProcessor(List<Individual> individualListTemp, int month) {
        return individualListTemp.stream()
                .filter(individual -> {
                    individual.extractMonthFromBirthDate();
                    individual.monthChecker(month);
                    return individual.getBirthDateMonth() == month;
                })
                .sorted(Comparator.comparing(Individual::getFirstName).thenComparing(Individual::getLastName))
                .collect(Collectors.toList());
    }

    /**
     * Fetches individual type objects into a list from a text file.
     * @param filePath File location.
     * @return A list of individual objects.
     * @throws IOException if File Not Found.
     */

    public List<Individual> getIndividualsFromFile(String filePath) throws IOException {
        Pattern pattern0 = Pattern.compile(" ");
        List<Individual> individualListTemp;
        try (Stream<String> lines = Files.lines(Path.of(filePath))) {
            individualListTemp = lines.map(line -> {
                String[] individualFields = pattern0.split(line);
                return new Individual(individualFields[0], individualFields[1], individualFields[2]);
            }).collect(Collectors.toList());
        }
        return individualListTemp;
    }

    // Parses the 2nd element in an object's getBirthDate and sets it as birthDateMonth.

    public void extractMonthFromBirthDate() {
        String[] tempSingleElementStringArray = getBirthDate().split("-");
        setBirthDateMonth(Integer.parseInt((tempSingleElementStringArray[1])));
    }

    // Simple method that checks for invalid months.

    public void monthChecker(int month) {
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException("Illegal month exception.");
        }
    }

    /**
     * Writes input data to file.
     * @param individualListTemp Takes in a list of objects type Individual.
     * @param filePathOutput Location where the file will write output.
     * @throws IOException in case of File Not Found error.
     */

    public void writeIndividualsToFile(List<Individual> individualListTemp, String filePathOutput) throws IOException {
        try (BufferedWriter bWriter0 = new BufferedWriter(new FileWriter(filePathOutput))) {
            bWriter0.write(String.valueOf(individualListTemp));
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}