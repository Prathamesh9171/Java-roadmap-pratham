import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();

        while (true) {

            System.out.println("\n=== Name Manager ===");
            System.out.println("1. Add Name");
            System.out.println("2. Show Names");
            System.out.println("3. Remove Name");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            sc.nextLine(); 

            if (ch == 4) {
                System.out.println("Bye!");
                break;
            }

            switch (ch) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    names.add(name);
                    System.out.println("Added!");
                    break;

                case 2:
                    if (names.isEmpty()) {
                        System.out.println("No names yet.");
                    } else {
                        for (String n : names) {
                            System.out.println(n);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter name to remove: ");
                    String rem = sc.nextLine();

                    if (names.remove(rem)) {
                        System.out.println("Removed!");
                    } else {
                        System.out.println("Name not found.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}


          
    
       
        
    

