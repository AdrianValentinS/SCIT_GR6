import java.util.Scanner;

public class exercitiu3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double nr1, nr2;

        nr1 = scanner.nextDouble();
        nr2 = scanner.nextDouble();
        double division = nr2 / nr1;

        if (nr1 == 0){
            System.out.println("error");
        }
        else {
            System.out.println(division);
        }
    }
}