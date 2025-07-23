package com.bb.core;

import java.util.Scanner;

/**
 * @author Baliram Bhande
 * @since 23-07-2025
 *
 * Write the following methods that return a lambda expression performing a specified action:
 * PerformOperation isOdd(): The lambda expression must return if a number is odd or if it is even.
 * PerformOperation isPrime(): The lambda expression must return if a number is prime or if it is composite.
 * PerformOperation isPalindrome(): The lambda expression must return if a number is a palindrome or if it is not.
 *
 *
 * Input Format
 * Input is handled for you by the locked stub code in your editor.
 * Output Format
 *
 *
 * The locked stub code in your editor will print lines of output.
 * Sample Input
 * The first line contains an integer, (the number of test cases).
 * The subsequent lines each describe a test case in the form of space-separated integers:
 * The first integer specifies the condition to check for ( for Odd/Even, for Prime, or for Palindrome). The second integer denotes the number to be checked.
 * 5
 * 1 4
 * 2 5
 * 3 898
 * 1 3
 * 2 12
 *
 * Sample Output
 * EVEN
 * PRIME
 * PALINDROME
 * ODD
 * COMPOSITE
 */
class PerformOperationOddEvenPrimePalidron {
    //Even or Odd Number checking
    public static PerformOperation isOdd() {
        return n -> n % 2 != 0;
    }

    //Is number is prime or not
    public static PerformOperation isPrime() {
        return n -> {
            if (n <= 1) return false;
            for (int i = 2; i < Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
    }

    // Is number is Palindrome
    public static PerformOperation isPalindrome() {
        return n -> {
            String original = String.valueOf(n);
            String reversed = new StringBuilder(original).reverse().toString();
            return original.equals(reversed);
        };
    }

    // call to method check for condition
    public boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    // Main method
    public static void main(String[] args) {
        PerformOperationOddEvenPrimePalidron test = new PerformOperationOddEvenPrimePalidron();
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        while (T-- > 0) {
            int condition = scanner.nextInt();
            int num = scanner.nextInt();
            PerformOperation operation;
            boolean result;

            switch (condition) {
                case 1:
                    operation = isOdd();
                    result = test.checker(operation, num);
                    System.out.println(result ? "ODD" : "EVEN");
                    break;

                case 2:
                    operation = isPrime();
                    result = test.checker(operation, num);
                    System.out.println(result ? "PRIME" : "COMPOSITE");
                    break;

                case 3:
                    operation = isPalindrome();
                    result = test.checker(operation, num);
                    System.out.println(result ? "PALINDROME" : "NOT-PALINDROME");
                    break;
                default:

                    System.out.println("Invalid Operation");

            }


        }
        scanner.close();

    }

    interface PerformOperation {
        boolean check(int a);
    }
}
