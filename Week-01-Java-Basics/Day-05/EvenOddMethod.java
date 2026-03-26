import java.util.Scanner;

public class EvenOddMethod {
    static  boolean isEven(int n){
        return n%2==0;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an number: ");
        int num = sc.nextInt();
       if( isEven(num))
        System.out.println(num + " is Even");
       else
        System.out.println(num + " is Odd");
    }
}
