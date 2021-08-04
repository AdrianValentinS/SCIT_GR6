import java.util.List;

public class PackageRunnable implements Runnable {

    private PackageGroup packageGroup;

    public PackageRunnable(PackageGroup packageGroup) {
        this.packageGroup = packageGroup;
    }

    @Override
    public void run() {
        for (Package delivery: packageGroup.getPackageList()){
            System.out.println("[" + "Delivering for " + "<" + delivery.getLocation() + ">" + " and date " + "<" + delivery.getDate() + ">" + " in " + "<" + delivery.getDistance() + ">" + " seconds" + "]");
            try {
                Thread.sleep(delivery.getDistance() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
