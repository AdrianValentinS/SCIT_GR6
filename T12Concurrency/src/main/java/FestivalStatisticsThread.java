public class FestivalStatisticsThread extends Thread {
    private FestivalGate festivalGate;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.festivalGate = gate;
    }

    // Takes in accumulator fields from festivalGate and prints out the data every 5 seconds.

    @Override
    public void run() {
        while (true) {
           if (festivalGate.getAttendeeAccumulator() != 0){
               System.out.println(
                       festivalGate.getAttendeeAccumulator() + " people entered\n"  +
                       festivalGate.getFullAccumulator() + " people have full tickets\n" +
                       festivalGate.getFreePassAccumulator() + " people have free passes\n" +
                       festivalGate.getFullVIPAccumulator() + " people have full VIP passes\n" +
                       festivalGate.getOneDayAccumulator() + " people have one-day passes\n" +
                       festivalGate.getOneDayVIPAccumulator() + " people have one-day VIP passes\n");
           } try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }
}

