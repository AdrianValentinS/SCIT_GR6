import java.util.Scanner;

public class exercitiu2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nr1, nr2;

        System.out.println("Enter first number: ");
        nr1 = scanner.nextInt();

        System.out.println("Enter second number: ");
        nr2 = scanner.nextInt();

        int dif = nr1 - nr2;

        System.out.println(dif);


    }
}
