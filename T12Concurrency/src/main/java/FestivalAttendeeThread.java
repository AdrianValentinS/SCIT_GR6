import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.Queue;

@Getter
@Setter
@ToString

public class FestivalAttendeeThread extends Thread {

    private FestivalGate festivalGate;
    private TicketType ticketType;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.festivalGate = gate;
    }

    // Generates an unlimited amount of threads which hold "tickets", and puts each in a queue.

    @Override
    public void run() {
        Queue<Object> threadQueue0 = new LinkedList<>();
        while (true) {
            Thread threadTemp = new Thread(TicketType.randomTicketType());
            festivalGate.attendeeThreadProcessor(String.valueOf(threadTemp));
            threadTemp.start();
            threadQueue0.offer(threadTemp);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}