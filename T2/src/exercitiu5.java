import java.util.Scanner;

class exercitiu5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String monthIndex = scanner.next().toString();

        switch (monthIndex) {

            case "1":
                System.out.println("31 days");
                break;

            case "2":
                System.out.println("28 or 29 days");
                break;

            case "3":
                System.out.println("31 days");
                break;

            case "4":
                System.out.println("30 days");
                break;

            case "5":
                System.out.println("31 days");
                break;

            case "6":
                System.out.println("30 days");
                break;

            case "7":
                System.out.println("31 days");
                break;

            case "8":
                System.out.println("31 days");
                break;

            case "9":
                System.out.println("30 days");
                break;

            case "10":
                System.out.println("31 days");
                break;

            case "11":
                System.out.println("30 days");
                break;

            case "12":
                System.out.println("31 days");
                break;

            default:
                System.out.println("you have not introduced month index");
        }
    }
}