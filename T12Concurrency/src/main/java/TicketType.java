import java.util.List;
import java.util.Random;

public enum TicketType {

    FULL,
    FULL_VIP,
    FREE_PASS,
    ONE_DAY,
    ONE_DAY_VIP;

    private static final List<TicketType> TYPES = List.of(values());
    private static final int SIZE = TYPES.size();
    private static final Random RANDOM = new Random();

    /**
     * Takes in a series of enums.
     * @return Generates an enum an converts to string.
     */

    public static String randomTicketType()  {
        return TYPES.get(RANDOM.nextInt(SIZE)).toString();
    }
}
