import java.util.Scanner;

class tema4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char operator;
        double number1, number2;

        System.out.println("Enter first number:");
        number1 = scanner.nextDouble();

        System.out.println("Insert operator:");
        operator = scanner.next().charAt(0);

        System.out.println("Enter second number");
        number2 = scanner.nextDouble();

        double resultPlus = number1 + number2;
        double resultMinus = number1 - number2;
        double resultDivide = number1 / number2;
        double resultMultiply = number1 * number2;

        switch (operator) {

            case '+':
                System.out.println(resultPlus);
                break;

            case '-':
                System.out.println(resultMinus);
                break;

            case '*':
                System.out.println(resultMultiply);
                break;

            case '/':
                System.out.println(resultDivide);
                break;
        }
    }
}