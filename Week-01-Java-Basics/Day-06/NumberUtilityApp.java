import java.util.Scanner;

public class NumberUtilityApp {

    
    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    
    static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    
    static int reverseNumber(int n) {
        int rev = 0;

        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n = n / 10;
        }

        return rev;
    }

    
    static boolean isPalindrome(int n) {
        int original = n;
        int rev = reverseNumber(n);

        return original == rev;
    }

    
    static int sumOfDigits(int n) {
        int sum = 0;

        while (n != 0) {
            sum += n % 10;
            n = n / 10;
        }

        return sum;
    }

    
    static int factorial(int n) {
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }

        return fact;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("==== Number Utility App ====");
            System.out.println();
            System.out.println("1. Check Even/Odd");
            System.out.println("2. Check Prime");
            System.out.println("3. Reverse Number");
            System.out.println("4. Palindrome Check");
            System.out.println("5. Sum of Digits");
            System.out.println("6. Factorial");
            System.out.println("7. Exit");
            System.out.println();
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            // Exit
            if (choice == 7) {
                System.out.println("Thank you! Bye ");
                break;
            }

            System.out.print("Enter a number: ");
            int num = sc.nextInt();

            switch (choice) {

                case 1:
                    if (isEven(num))
                        System.out.println("Even Number");
                    else
                        System.out.println("Odd Number");
                    break;

                case 2:
                    if (isPrime(num))
                        System.out.println("Prime Number");
                    else
                        System.out.println("Not Prime");
                    break;

                case 3:
                    System.out.println("Reverse: " + reverseNumber(num));
                    break;

                case 4:
                    if (isPalindrome(num))
                        System.out.println("Palindrome");
                    else
                        System.out.println("Not Palindrome");
                    break;

                case 5:
                    System.out.println("Sum of Digits: " + sumOfDigits(num));
                    break;

                case 6:
                    System.out.println("Factorial: " + factorial(num));
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

            System.out.println(); 
        }

        sc.close();
    }
}
