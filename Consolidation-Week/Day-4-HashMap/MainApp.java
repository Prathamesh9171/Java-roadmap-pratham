import java.util.HashMap;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,String> map = new HashMap<Integer,String>();

        while(true){
            System.out.println("\n=== Student Directory (Hashmap) ===");
            System.out.println("1. Add student ");
            System.out.println("2. Show All ");
            System.out.println("3. Search by roll");
            System.out.println("4. Delete by roll");
            System.out.println("5. Exit");

            System.out.print("Enter Choice:");
            int ch = sc.nextInt();

            if(ch==5){
                System.out.println("Bye");
                break;
            }
            switch (ch) {
                case 1:
                    System.out.print("Enter roll: ");
                    int r = sc.nextInt();
                    
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String n = sc.nextLine();
                    map.put(r, n);
                    System.out.println("Student added.");
                    break;

                case 2: 
                    if(map.isEmpty()){
                        System.out.print("No Student avilable.");
                    }
                    else{
                        for(Integer key : map.keySet()){
                            System.out.println(key +" | "+ map.get(key));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter roll to Search: ");
                    int sr = sc.nextInt();

                    if(map.containsKey(sr)){
                        System.out.println("Found: "+ sr +" | "+ map.get(sr));
                    }else{
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter roll to Search: ");
                    int dr = sc.nextInt();

                    if(map.remove(dr) != null){
                        System.out.println("Student Deleted. ");
                    }else{
                        System.out.println("Student not found.");
                    }
                    break;


            
                default:
                   System.out.println("Invalid choice.");
            }
            
        }

    sc.close();
    }
}
