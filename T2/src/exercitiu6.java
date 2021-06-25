import java.util.Scanner;

public class exercitiu6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int produs = 1;

        for (int i = 1; i <= n; i = i + 1) {
               produs = (produs * i);
        }

        System.out.println(produs);
    }
}
