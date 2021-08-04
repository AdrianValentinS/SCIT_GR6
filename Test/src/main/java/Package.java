import lombok.Getter;

@Getter
public class Package {
    private String location;
    private int distance;
    private int value;
    private String date;

    public Package(String location, int distance, int value, String date) {
        this.location = location;
        this.distance = distance;
        this.value = value;
        this.date = date;
    }
}
