package validate;

import java.util.Scanner;

public class Validate {
    static Scanner scanner = new Scanner(System.in);

    public int validateId() {
        while (true) {
            try {
                System.out.println("enter product id");
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("wrong format, enter number");
            }
        }
    }

    public int validateQuantity() {
        while (true) {
            try {
                System.out.println("enter quantity");
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("wrong format, enter number");
            }
        }
    }

    public double validatePrice() {
        while (true) {
            try {
                System.out.println("enter price");
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("wrong format, enter decimal numer ");
            }
        }
    }
}