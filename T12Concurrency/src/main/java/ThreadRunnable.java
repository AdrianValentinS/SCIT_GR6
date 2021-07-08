public class ThreadRunnable implements Runnable {
    private String ticketType;

    @Override
    public void run() {
        ticketType = TicketType.randomTicketType();
    }
    public String getTicketType() {
       return ticketType;
    }
}