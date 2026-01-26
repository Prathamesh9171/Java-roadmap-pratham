import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter principal (P): ");
        double p = sc.nextDouble();

        System.out.print("Enter rate (R): ");
        double r = sc.nextDouble();

        System.out.print("Enter time (T): ");
        double t = sc.nextDouble();

        double si = (p * r * t) / 100;

        System.out.println("Simple Interest = " + si);

        sc.close();
    }
}

