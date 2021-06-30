public class Main {
    public static void main(String[] args) {

        FestivalGate gate = new FestivalGate();

        TicketType ticketType = TicketType.valueOf(TicketType.randomTicketType());

        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);

        statsThread.start();

        FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(ticketType, gate);

        festivalAttendee.start();

    }
}