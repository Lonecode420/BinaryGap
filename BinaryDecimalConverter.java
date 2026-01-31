import java.util.Scanner;

public class BinaryDecimalConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Binary ↔ Decimal Converter ===");
        System.out.println("1. Binary to Decimal");
        System.out.println("2. Decimal to Binary");
        System.out.print("Choose an option (1 or 2): ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter a binary number: ");
                String binary = scanner.next();
                int decimal = Integer.parseInt(binary, 2);
                System.out.println("Decimal value: " + decimal);
                break;

            case 2:
                System.out.print("Enter a decimal number: ");
                int dec = scanner.nextInt();
                String bin = Integer.toBinaryString(dec);
                System.out.println("Binary value: " + bin);
                break;

            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
