import java.util.Scanner;

public class SumOfDigits {
    static int sumDigits(int n){
         int sum = 0;
         n = Math.abs(n);
         while(n>0){
            sum+= n%10;
            n /= 10;
         }
         return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an number: ");
        int num =sc.nextInt();  
        
        int result = sumDigits(num);
        System.out.println(result);
    }
}
