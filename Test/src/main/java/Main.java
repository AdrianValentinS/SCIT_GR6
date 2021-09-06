import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        PackageDelivery packageDelivery = new PackageDelivery();

        packageDelivery.readDeliveryFile("src/main/resources/packages.txt");

        packageDelivery.groupPackages();

        deliverPackages(packageDelivery.getPackageMap());


    }

    private static void deliverPackages(Map<String, Map<String, PackageGroup>> orderList) throws InterruptedException {
        int totalValue = 0;
        int totalRevenue = 0;
        ArrayList<Thread> threadList = new ArrayList<>();

        for (Map.Entry<String, Map<String, PackageGroup>> locationGroup : orderList.entrySet()) {
            for(Map.Entry<String, PackageGroup> packageGroup : locationGroup.getValue().entrySet()) {

                totalValue += packageGroup.getValue().getDeliveryValue();
                totalRevenue += packageGroup.getValue().getRevenue();

                PackageRunnable runnable = new PackageRunnable(packageGroup.getValue());
                Thread thread = new Thread(runnable);
                threadList.add(thread);
                thread.start();

            }
        }
        for(Thread thread : threadList){
            thread.join(); // Blocking until all threads complete.
        }

        System.out.println("Total value of all delivered packages: " + totalValue + " LEU");
        System.out.println("Total revenue for all delivered groups: " + totalRevenue + " LEU");
    }
}
