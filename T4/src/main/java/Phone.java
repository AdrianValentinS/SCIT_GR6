import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Phone {

    private String phoneModel;          // Proprietati individuale ale telefoanelor.
    private String phoneManufacturer;
    private String phoneColor;
    private String phoneMaterial;
    private String phoneIMEI;

    private static final int phoneBatteryMin = 0;       // Functionalitatea bateriei.
    private int phoneBatteryCurrent;
    private int phoneBatteryMax;

    protected Phone(String phoneModel, String phoneManufacturer, String phoneColor,
                    String phoneMaterial, String phoneIMEI, int phoneBatteryMax) {

        contactHashMap = new HashMap<String, Contact>();       // Hash man pentru proprietatiile unui Phone.

        this.phoneModel = phoneModel;
        this.phoneManufacturer = phoneManufacturer;
        this.phoneColor = phoneColor;
        this.phoneMaterial = phoneMaterial;
        this.phoneIMEI = phoneIMEI;
        this.phoneBatteryMax = phoneBatteryMax;
        phoneBatteryCurrent = phoneBatteryMax;

    }

    public void listMessage(String phoneNumber) {           // Metoda pentru printare mesaje.
        if (contactHashMap.containsKey(phoneNumber)) {
            contactHashMap.get(phoneNumber).printMessages();
        } else {
            System.out.println("This contact doesn't exist.");
        }
    }

    List<String> callHistory = new ArrayList<String>();     // Lista pentru stocarea apelurilor.

    public void call(String phoneNumber) {
        callHistory.add(phoneNumber);

        System.out.println("Calling contact.");

        phoneBatteryCurrent -= 2;

        System.out.println("Battery life: " + phoneBatteryCurrent + " hours left.");

    }

    public void viewCallHistory() {
        System.out.println("Call history: " + callHistory);
    }


    public void sendMessages(String phoneNumber, String messageContent){    // Elseif pentru trimiterea mesajelor.
        int messageLength = messageContent.length();
            if (messageLength > 500){

                return;

            } else if (contactHashMap.containsKey(phoneNumber)){

                System.out.println("Message sent.");

                Contact myContact = contactHashMap.get(phoneNumber);

                myContact.addMessage(messageContent);

                phoneBatteryCurrent--;

                System.out.println("Battery life: " + phoneBatteryCurrent + " hours left.");

            }

    }

    HashMap<String, Contact> contactHashMap;

    public void listContacts() {          // Aici se permite printarea contactelor prin HashMap values.

        System.out.println("Contact list:");

        for (Contact contactVar : contactHashMap.values())
        {
            System.out.println(contactVar.toString());
        }

    }

    public void addContact(String contactID, String phoneNumber, String firstName, String lastName){        // Aici se permite adaugarea contactelor noi prin contactHashMap .put .
        Contact newContact = new Contact(contactID, phoneNumber, firstName, lastName);
        contactHashMap.put(phoneNumber, newContact);

    }

}
