public class Samsung extends Phone{ // Aici si in superclasa se permite instantierea obiectelor de tip phone si/sau galaxyS6.

    protected Samsung(String phoneModel, String phoneColor, String phoneMaterial, String phoneIMEI, int maxBatteryLife) {
        super(phoneModel, "Samsung", phoneColor, phoneMaterial, phoneIMEI, maxBatteryLife);
    }
}
