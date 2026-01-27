import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
          
          System.out.print("Enter Year: "); 
         int year = sc.nextInt();

         if(year%400==0)
            System.out.print("Leap Year ");
        else if(year%100==0)
            System.out.print("Not a leap Year"); 
         else if (year%4==0)
            System.out.print("Leap Year");  
            else
                 System.out.print("Not a leap Year"); 
         
    }
    
}
