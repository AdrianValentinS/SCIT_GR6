public class Main{

    public static void main(String[] args) {

        Phone phone0 = new GalaxyS6("Pink", "Plastic", "361557429983164"); // Aici instantiam telefoane si atributiile/functiile respective.
        phone0.addContact("1", "0751666639", "Ben", "Spencer");
        phone0.addContact("2", "0751666849", "Kenneth", "Hood");
        phone0.listContacts();

        phone0.sendMessages("0751666849", "This is an example message.");
        phone0.listMessage("0751666849");

        phone0.call("0751666849");
        phone0.viewCallHistory();

        Phone phone1 = new Zenfone4Max("Black", "Metal", "865187010550746");


    }
}
