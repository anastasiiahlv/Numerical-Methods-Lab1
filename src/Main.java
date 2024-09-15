import static java.lang.Math.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = -1;

        while(n != 0) {
            System.out.println("Enter the precision (e.g., 10e-4): ");
            String input = sc.next();
            double epsilon = 0;

            if (input.matches("^[0-9]+(\\.[0-9]+)?[eE][+-]?[0-9]+$")) {
                epsilon = Double.parseDouble(input);
            } else {
                System.out.println("Invalid input. Please try again.");
                continue;
            }

            System.out.println("Choose the method. Enter 1 or 2.");
            System.out.println("1 - Simple Iteration Method");
            System.out.println("2 - Modified Newton Method");
            System.out.println("Enter: ");

            if (sc.hasNextInt()) {
                int selectedMethod = sc.nextInt();

                switch (selectedMethod) {
                    case 1:
                        SimpleIterationMethod.method(epsilon);
                        break;
                    case 2:
                        ModifiedNewtonMethod.method(epsilon);
                        break;
                    default:
                        System.out.println("Invalid selection.");
                        continue;
                }
            } else {
                System.out.println("Invalid input. Please enter a number 1 or 2.");
                sc.next();
                continue;
            }

            System.out.println("Enter 1 to continue, 0 to exit.");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
            } else {
                System.out.println("Invalid input. Exiting.");
                break;
            }
        }
        sc.close();
    }
}