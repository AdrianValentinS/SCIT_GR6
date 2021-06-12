import java.util.ArrayList;

/**
 * This is a program which sorts its objects within an ArrayList based on a single parameter SalesQuota specific to each object using a descending bubble sort.
 */

public class Main{
    public static void main(String[] args) {

        SalesRepresentative rep0 = new SalesRepresentative(10, 500);  // Object declaration and instantiation.
        SalesRepresentative rep1 = new SalesRepresentative(7, 800);
        SalesRepresentative rep2 = new SalesRepresentative(5, 1000);
        SalesRepresentative rep3 = new SalesRepresentative(9, 600);
        SalesRepresentative rep4 = new SalesRepresentative(12, 500);
        SalesRepresentative rep5 = new SalesRepresentative(14, 400);

        ArrayList<SalesRepresentative> repList = new ArrayList<>();  //Array declaration and instantiation.

        repList.add(rep0);  // Adding objects to the arraylist.
        repList.add(rep1);
        repList.add(rep2);
        repList.add(rep3);
        repList.add(rep4);
        repList.add(rep5);

        System.out.println("Sales representatives total sales:" + repList);
        repList.get(0).sort(repList); // This executes the sorting function.
        System.out.println("Sales representatives total sales by profit margin:" + repList );


    }
}
