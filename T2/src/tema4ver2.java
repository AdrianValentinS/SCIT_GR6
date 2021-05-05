import java.util.Scanner;

class tema4ver2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char operator;
        double number1, number2, result;

        System.out.println("Enter first number:");
        number1 = scanner.nextDouble();

        System.out.println("Insert operator:");
        operator = scanner.next().charAt(0);

        System.out.println("Enter second number");
        number2 = scanner.nextDouble();

        switch (operator) {

            case '+':
                result = number1 + number2;
                System.out.println(result);
                break;

            case '-':
                result = number1 - number2;
                System.out.println(result);
                break;

            case '*':
                result = number1 * number2;
                System.out.println(result);
                break;

            case '/':
                result = number1 / number2;
                System.out.println(result);
                break;
        }
    }
}