import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        while (true) {

            System.out.println("\n=== Student Management ===");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Search by Roll");
            System.out.println("4. Delete by Roll");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 5) {
                System.out.println("Bye!");
                break;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll: ");
                    int r = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String n = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double m = sc.nextDouble();

                    list.add(new Student(r, n, m));
                    System.out.println("Student added!");
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        for (Student s : list) {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter roll to search: ");
                    int sr = sc.nextInt();

                    boolean found = false;

                    for (Student s : list) {
                        if (s.getRoll() == sr) {
                            s.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Student not found.");
                    break;

                case 4:
                    System.out.print("Enter roll to delete: ");
                    int dr = sc.nextInt();

                    boolean removed = false;

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getRoll() == dr) {
                            list.remove(i);
                            removed = true;
                            System.out.println("Student deleted.");
                            break;
                        }
                    }

                    if (!removed)
                        System.out.println("Student not found.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
