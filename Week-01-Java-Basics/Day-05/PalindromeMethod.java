import java.util.Scanner;

public class PalindromeMethod {
    static boolean isPalindrome(int n){
        int original = n;
        int reverse = 0;
        while(n>0){
            int digit = n%10;
            reverse =reverse*10+digit;
           n=n/10;
        }
        return original==reverse;
         
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an number: ");
        int num =sc.nextInt();  

        if (isPalindrome(num))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}
