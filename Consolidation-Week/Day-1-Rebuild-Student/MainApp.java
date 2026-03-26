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
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 3) {
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

                    Student s = new Student(r, n, m);
                    list.add(s);

                    System.out.println("Student added!");
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        for (Student student : list) {
                            student.display();
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
