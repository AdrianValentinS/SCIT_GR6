import java.util.Scanner;

public class tema3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");

        int a = scanner.nextInt();

        if(a > 0 && a < 10){
            System.out.println("Number is smaller than 10");
        }else if(a >= 10 && a < 20){
            System.out.println("Number is between 10 - 20");
        }else if(a > 30){
            System.out.println("Number is greater than 30");
        }

    }
}

