import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PackageGroup {
    private int deliveryValue = 0;
    private int revenue = 0;
    private List<Package> packageList = new ArrayList<>();

    public void addPackage(Package newPackage){
        deliveryValue += newPackage.getValue();
        revenue += newPackage.getDistance();
        packageList.add(newPackage);
    }
}
