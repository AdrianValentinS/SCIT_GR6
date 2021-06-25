import java.util.Scanner;

public class CalculatorMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // The basic variables we work with.

        int intermediaryResult = 0;
        int number1, number2, number3;
        String unit1, unit2, unit3;
        char operator1, operator2;

        number1 = getNumber1(scanner);

        unit1 = getUnit1(scanner);

        operator1 = getOperator1(scanner);

        number2 = getNumber2(scanner);

        unit2 = getUnit2(scanner);

        operator2 = getOperator2(scanner);

        number3 = getNumber3(scanner);

        unit3 = getUnit3(scanner);

        // Testing method for calculating input.

        intermediaryResult = doCalculation(intermediaryResult, number1, number2, number3, unit1, unit2, unit3,
				operator1, operator2);

        System.out.println(intermediaryResult + " mm");

    }

    // pass by expression

    // Scanner methods for reducing clutter in main.

    private static String getUnit3(Scanner scanner) {
        String unit3;
        System.out.println("Enter third unit:");
        unit3 = scanner.nextLine().trim();
        return unit3;
    }

    private static int getNumber3(Scanner scanner) {
        int number3;
        System.out.println("Enter third number:");
        number3 = scanner.nextInt();
        scanner.nextLine();
        return number3;
    }

    private static char getOperator2(Scanner scanner) {
        char operator2;
        System.out.println("Enter second operator:");
        operator2 = scanner.next().charAt(0);
        scanner.nextLine();
        return operator2;
    }

    private static String getUnit2(Scanner scanner) {
        String unit2;
        System.out.println("Enter second unit:");
        unit2 = scanner.nextLine().trim();
        return unit2;
    }

    private static int getNumber2(Scanner scanner) {
        int number2;
        System.out.println("Enter second number:");
        number2 = scanner.nextInt();
        scanner.nextLine();
        return number2;
    }

    private static char getOperator1(Scanner scanner) {
        char operator1;
        System.out.println("Enter first operator:");
        operator1 = scanner.next().charAt(0);
        scanner.nextLine();
        return operator1;
    }

    private static String getUnit1(Scanner scanner) {
        String unit1;
        System.out.println("Enter first unit:");
        unit1 = scanner.nextLine().trim();
        return unit1;
    }

    private static int getNumber1(Scanner scanner) {
        int number1;
        System.out.println("Enter first number:");
        number1 = scanner.nextInt();
        scanner.nextLine();
        return number1;
    }

    public static int doCalculation(int intermediaryResult, int number1, int number2, int number3, String unit1,
			String unit2, String unit3, char operator1, char operator2) {
		number1 = convertToMM(number1, unit1);
        number2 = convertToMM(number2, unit2);
        number3 = convertToMM(number3, unit3);


        // Operator and conversion methods for the numbers.

        switch (operator1) {
            case '+':
                intermediaryResult = number1 + number2;
                break;

            case '-':
            	intermediaryResult = number1 - number2;
                break;
        }
        switch (operator2) {
	        case '+':
	            intermediaryResult += number3;
	            break;

	        case '-':
	        	intermediaryResult -= number3;
	            break;
        }
		return intermediaryResult;
	}

	public static int convertToMM(int number, String unit) {
		switch (unit) {
	        case "mm":
	            number = number;
	            break;
	        case "cm":
	            number = number * 10;
	            break;
	        case "dm":
	            number = number * 100;
	            break;
	        case "m":
	            number = number * 1000;
	            break;
	        case "km":
	            number = number * 1000000;
	            break;
        }
		return number;
	}
}