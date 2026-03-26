import java.util.Scanner;

public class PrintNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter integer: ");
        int n = sc.nextInt();

        for (int i = 1 ; i <= n; i++) {
            System.out.print(i + " ");
        }
      
    }
    
}
