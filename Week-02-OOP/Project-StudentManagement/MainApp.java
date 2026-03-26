import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {

            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Search by Roll");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 5) {
                System.out.println("Thank you! Bye ");
                break;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll: ");
                    int r = sc.nextInt();

                    sc.nextLine(); // clear buffer

                    System.out.print("Enter Name: ");
                    String n = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double m = sc.nextDouble();

                    Student s = new Student(r, n, m);
                    service.addStudent(s);
                    break;

                case 2:
                    service.showAll();
                    break;

                case 3:
                    System.out.print("Enter roll to search: ");
                    int sr = sc.nextInt();

                    service.searchByRoll(sr);
                    break;

                case 4:
                    System.out.print("Enter roll to delete: ");
                    int dr = sc.nextInt();

                    service.deleteByRoll(dr);
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}
