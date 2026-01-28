import java.util.Scanner;

public class SumOfN {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          System.out.print("Enter integer: ");
          int n = sc.nextInt();
          
          int sum = 1;
          for(int i= 1;i<=n;i++){
            sum = sum + i ;
          }
         System.out.println("Sum = " +sum);
    }
}
