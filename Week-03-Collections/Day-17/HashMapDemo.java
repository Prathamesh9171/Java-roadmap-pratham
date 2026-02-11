import java.util.HashMap;
import java.util.Scanner;

public class HashMapDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<Integer, String> map = new HashMap<>();

        while (true) {

            System.out.println("\n=== Student Directory ===");
            System.out.println("1. Add Student");
            System.out.println("2. Show All");
            System.out.println("3. Search by Roll");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            sc.nextLine();

            if (ch == 5) {
                System.out.println("Bye!");
                break;
            }

            switch (ch) {
                case 1:
                    System.out.print("Enter Roll: ");
                    int r = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String n = sc.nextLine();

                    map.put(r, n);
                    System.out.println("Added!");
                    break;

                case 2:
                    if (map.isEmpty()) {
                        System.out.println("No records.");
                    } else {
                        for (int key : map.keySet()) {
                            System.out.println(key + " -> " + map.get(key));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter roll to search: ");
                    int sr = sc.nextInt();

                    if (map.containsKey(sr)) {
                        System.out.println("Name: " + map.get(sr));
                    } else {
                        System.out.println("Not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter roll to delete: ");
                    int dr = sc.nextInt();

                    if (map.remove(dr) != null) {
                        System.out.println("Deleted.");
                    } else {
                        System.out.println("Not found.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
