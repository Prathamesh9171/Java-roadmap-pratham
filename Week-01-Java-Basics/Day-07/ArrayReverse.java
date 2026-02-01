import java.util.Scanner;

public class ArrayReverse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i <= 4; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Reversed array:");
        for (int i = 4; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
