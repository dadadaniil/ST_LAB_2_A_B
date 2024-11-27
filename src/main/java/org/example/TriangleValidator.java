package org.example;

import java.util.Scanner;

public class TriangleValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter three non-negative integers (or 'exit' to quit):");
        while (scanner.hasNext()) {
            try {
                String input1 = scanner.next();
                if (input1.equalsIgnoreCase("exit")) break;
                int a = Integer.parseInt(input1);

                String input2 = scanner.next();
                int b = Integer.parseInt(input2);

                String input3 = scanner.next();
                int c = Integer.parseInt(input3);

                String result = determineTriangleType(a, b, c);
                System.out.println(result);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter integers only.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static boolean isTriangle(int a, int b, int c) {
        return (a > 0 && b > 0 && c > 0) &&
            (a + b > c) && (b + c > a) && (c + a > b);
    }

    public static String determineTriangleType(int a, int b, int c) {
        if (!isTriangle(a, b, c)) {
            return "Invalid Triangle";
        }
        if (a == b && b == c) {
            return "Equilateral";
        } else if (a == b || b == c || c == a) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }
}
