import java.util.ArrayList;

public class SalesRepresentative {

    private int sales;
    private int salesQuota;
    private int salesTotal;

    public SalesRepresentative(int sales, int salesQuota) {     // Allows salesTotal functionality.
        this.sales = sales;
        this.salesQuota = salesQuota;
        this.salesTotal = sales * salesQuota;
    }

    /**
     * Bubble sort with functionality adapted to use salesTotal to sort in descending order.
     */

    public void sort(ArrayList<SalesRepresentative> reps){
        for (int i = 0; i < reps.size() - 1; i++){
            for (int j = 0; j < reps.size() - 1 - i; j++){
                if (reps.get(j).getSalesTotal() < reps.get(j + 1).getSalesTotal()) {
                    int temp = reps.get(j).getSalesTotal();
                    reps.get(j).setSalesTotal(reps.get(j + 1).getSalesTotal());
                    reps.get(j + 1).setSalesTotal(temp);
                }
            }
        }
    }

    // Getters and setters for salesTotal.

    public int getSalesTotal() {
        return salesTotal;
    }

    public void setSalesTotal(int salesTotal) {
        this.salesTotal = salesTotal;
    }

    @Override
    public String toString() {
        return ("" + salesTotal);

    }
}