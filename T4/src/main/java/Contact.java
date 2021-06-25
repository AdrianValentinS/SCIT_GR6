import org.apache.commons.lang3.ArrayUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Contact {

    public void addMessage(String messageContent){
        messagesList.add(messageContent);
    }  // Permite adaugarea mesagelor.

    List<String> messagesList = new ArrayList<String>();  // Lista permite stocarea mesajelor.

    public void printMessages() {
        System.out.println(messagesList);
    }  // Permite printarea mesagelor.

    String contactID;
    String phoneNumber;
    String firstName;
    String lastName;

    public Contact(String contactID, String phoneNumber, String firstName, String lastName) { // Aici sunt stocati parametrii pentru contactele unui phone.
        this.contactID = contactID;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return firstName + " " +  lastName + " " + phoneNumber;
    }
}
