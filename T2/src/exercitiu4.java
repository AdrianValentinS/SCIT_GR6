import java.util.Scanner;

public class exercitiu4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int a = scanner.nextInt();
        System.out.println("Enter second number: ");
        int b = scanner.nextInt();
        if (a == 5 && b == 6){
            System.out.println("Number is either 5 or 6");
        }
        else {
            System.out.println("Number is neither 5 nor 6");
        }
    }
}
