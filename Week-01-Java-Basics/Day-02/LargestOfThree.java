import java.util.Scanner;

public class LargestOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
          System.out.print("Enter Three Number: "); 
         int a = sc.nextInt();
         int b = sc.nextInt();
         int c = sc.nextInt();

         System.out.print("Largest Number: ");
         if(a>b && a>c)
            System.out.println(a);
        else if(b>c)
            System.out.println(b);
        else
            System.out.println(c);



    }
}
