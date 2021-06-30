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
            case "Thread[FULL,5,main]" -> {
                fullAccumulator++;
                attendeeAccumulator++;
            }
            case "Thread[FULL_VIP,5,main]" -> {
                fullVIPAccumulator++;
                attendeeAccumulator++;
            }
            case "Thread[FREE_PASS,5,main]" -> {
                freePassAccumulator++;
                attendeeAccumulator++;
            }
            case "Thread[ONE_DAY,5,main]" -> {
                oneDayAccumulator++;
                attendeeAccumulator++;
            }
            case "Thread[ONE_DAY_VIP,5,main]" -> {
                oneDayVIPAccumulator++;
                attendeeAccumulator++;
            }
        }
    }
}