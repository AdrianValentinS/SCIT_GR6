public class Asus extends Phone {     // Aici si in superclasa se permite instantierea obiectelor de tip phone si/sau galaxyS6.

    protected Asus(String phoneModel, String phoneColor, String phoneMaterial, String phoneIMEI, int maxBatteryLife) {
        super(phoneModel, "Asus", phoneColor, phoneMaterial, phoneIMEI, maxBatteryLife);
    }
}
