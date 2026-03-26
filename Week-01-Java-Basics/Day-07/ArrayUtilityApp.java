import java.util.Scanner;

public class ArrayUtilityApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        while (true) {
            System.out.println("\n=== Array Utility App ===");
            System.out.println("1. Enter Numbers");
            System.out.println("2. Display Numbers");
            System.out.println("3. Sum");
            System.out.println("4. Max");
            System.out.println("5. Min");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 6) {
                System.out.println("Bye!");
                break;
            }

            switch (choice) {

                case 1:
                    System.out.println("Enter 5 numbers:");
                    for (int i = 0; i < 5; i++) {
                        arr[i] = sc.nextInt();
                    }
                    break;

                case 2:
                    for (int i = 0; i < 5; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;

                case 3:
                    int sum = 0;
                    for (int i = 0; i < 5; i++) {
                        sum += arr[i];
                    }
                    System.out.println("Sum = " + sum);
                    break;

                case 4:
                    int max = arr[0];
                    for (int i = 1; i < 5; i++) {
                        if (arr[i] > max)
                            max = arr[i];
                    }
                    System.out.println("Max = " + max);
                    break;

                case 5:
                    int min = arr[0];
                    for (int i = 1; i < 5; i++) {
                        if (arr[i] < min)
                            min = arr[i];
                    }
                    System.out.println("Min = " + min);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
