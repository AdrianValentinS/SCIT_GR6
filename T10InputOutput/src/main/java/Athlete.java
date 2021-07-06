import java.util.*;
import lombok.*;

public class Athlete {

    @Getter
    @Setter


    // Typical object list/field code.

    List<Athlete> athleteList;

    private int athleteNumber;
    private String athleteName;
    private String countryCode;
    private String skiTimeResult;
    private String firstShootingRangeMisses; // for each: shots missed out of five
    private String secondShootingRangeMisses;
    private String thirdShootingRangeMisses;
    private int seconds;
    private int rangeFailureResult;

    public Athlete(int athleteNumber, String athleteName, String countryCode, String skiTimeResult, String firstShootingRangeMisses, String secondShootingRangeMisses, String thirdShootingRangeMisses) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingRangeMisses = firstShootingRangeMisses;
        this.secondShootingRangeMisses = secondShootingRangeMisses;
        this.thirdShootingRangeMisses = thirdShootingRangeMisses;
    }

    /**
     * Processes xxxxx type fields.
     * @param s Loads each character and for each 'o' accumulates a number.
     * @return Returns non-multiplied second penalty.
     */

    public int stringParser(String s) {
        int accumulator = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'o'){
                accumulator++;
            }
        }
        return accumulator;
    }

    /**
     * Calculates time in a Minute:Second format.
     * @param seconds Raw seconds as input.
     * @return Time as Minute:Seconds.
     */

    public static String timeCalculator(int seconds) {
        int p1 = seconds % 60;
        int p2 = seconds / 60;
        return p2 + ":" + p1;
    }

    /**
     * Calculates using input from stringParser. For each athlete, multiplies accumulator value by 10.
     * @return Returns a value used for printing the actual second penalty for a specific athlete.
     */

    public int rangeFailureCalculator() {
        return rangeFailureResult = (stringParser(firstShootingRangeMisses) * 10) + (stringParser(secondShootingRangeMisses) * 10) + (stringParser(thirdShootingRangeMisses) * 10);
    }

    public int getRangeFailureResult() {
        return rangeFailureResult;
    }

    /**
     * Re-calculates time after it was parsed in a Minutes:Seconds format.
     * @param inputString Takes in Minutes:Seconds as a string, transforms into Integer using .parseInt.
     * @return Returns seconds as a raw value.
     */

    public static int calculatorStringSplitter(String inputString) {
        int seconds;
        String[] splitNumbers = inputString.split(":");
        seconds = Integer.parseInt(splitNumbers[0]) * 60 + Integer.parseInt(splitNumbers[1]);
        return seconds;
    }

    /**
     * Merges subservient methods together for use in the method reference comparator.
     * @return Returns true second value.
     */

    public int skiTimeResultCalculated() {
        int seconds = rangeFailureCalculator() + calculatorStringSplitter(this.skiTimeResult);
        return this.seconds = seconds;
    }

    public String getSkiTimeResult() {
        return skiTimeResult;
    }

    /**
     * Method reference comparator. Takes objects in a list and prints the top 3 objects in a specific way.
     * @param athleteList The object list to be sorted by skiTimeResultCalculated.
     */

    public static void compareWinnersJava8(List<Athlete> athleteList) {
        Comparator<Athlete> victoryComparator = Comparator.comparing(Athlete::skiTimeResultCalculated);
        athleteList.sort(victoryComparator);

        Athlete winner = athleteList.get(0);
        Athlete runnerUp = athleteList.get(1);
        Athlete thirdPlace = athleteList.get(2);

        System.out.println("Winner - " + winner + "(" + winner.getSkiTimeResult() + " + " + winner.getRangeFailureResult() + ")");
        System.out.println("Runner-up - " + runnerUp + "(" + runnerUp.getSkiTimeResult() + " + " + runnerUp.getRangeFailureResult() + ")");
        System.out.println("Third Place - " + thirdPlace + "(" + thirdPlace.getSkiTimeResult() + " + " + thirdPlace.getRangeFailureResult() +")");

    }

    // This toString is responsible for printing the middle segment of an athlete, the name and the final time result.

    @Override
    public String toString() {
        return athleteName + " " + Athlete.timeCalculator(skiTimeResultCalculated()) ;
    }
}
