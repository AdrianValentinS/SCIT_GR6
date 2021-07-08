import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FestivalGate {

    // For each thread with a specific ticket type, increments both the attendee accumulator and the ticket-specific accumulator.

private int attendeeAccumulator = 0;
private int fullAccumulator = 0;
private int fullVIPAccumulator = 0;
private int freePassAccumulator = 0;
private int oneDayAccumulator = 0;
private int oneDayVIPAccumulator = 0;

public void attendeeThreadProcessor(String tempString) {
        switch (tempString) {
            case "FULL" -> {
                fullAccumulator++;
                attendeeAccumulator++;
            }
            case "FULL_VIP" -> {
                fullVIPAccumulator++;
                attendeeAccumulator++;
            }
            case "FREE_PASS" -> {
                freePassAccumulator++;
                attendeeAccumulator++;
            }
            case "ONE_DAY" -> {
                oneDayAccumulator++;
                attendeeAccumulator++;
            }
            case "ONE_DAY_VIP" -> {
                oneDayVIPAccumulator++;
                attendeeAccumulator++;
            }
        }
    }
}