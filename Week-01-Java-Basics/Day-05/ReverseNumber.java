import java.util.Scanner;

public class ReverseNumber {
    static int reverseNumber(int n){
         int reverse = 0;
        while(n>0){
            int digit = n%10;
            reverse =reverse*10+digit;
           n=n/10;
        }
        return reverse;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an number: ");
        int num =sc.nextInt();  
        System.out.println("Reverse Number: "+ reverseNumber(num));
    }

}
