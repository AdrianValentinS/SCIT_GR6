import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PackageDelivery {
    private List<Package> packageList;
    @Getter
    private Map<String, Map<String, PackageGroup>> packageMap;

    public PackageDelivery() {
        packageList = new ArrayList<>();
        packageMap = new HashMap<>();
    }

    public void groupPackages() {
        for (Package newPackage: packageList) {

            if (!packageMap.containsKey(newPackage.getLocation())) {
                packageMap.put(newPackage.getLocation(), new HashMap<>());
            }

            Map<String, PackageGroup> packageLocation = packageMap.get(newPackage.getLocation());
            if(!packageLocation.containsKey(newPackage.getDate())){
                packageLocation.put(newPackage.getDate(), new PackageGroup());
            }
            packageLocation.get(newPackage.getDate()).addPackage(newPackage);
        }
    }

    public void readDeliveryFile(String filepath) {
        try (FileReader fileReader = new FileReader(filepath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()){
                    continue;
                }
                String[] args = line.split(",");

                Package newPackage = new Package(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
                packageList.add(newPackage);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
