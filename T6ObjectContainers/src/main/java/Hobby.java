import java.util.List;

public class Hobby{

    private String hobby;
    private int frecventa;
    private List<Adresa> addresses;


    public Hobby(String hobby, int frecventa, List<Adresa> addresses) {
        super();
        this.hobby = hobby;
        this.frecventa = frecventa;
        this.addresses = addresses;
    }

    public Hobby() {
    }

    @Override
    public String toString() {
        return "\nHobby = " + hobby + "\nFrecventa pe saptamana = " + frecventa + "\nAdresa = " + addresses.toString();
    }

}
