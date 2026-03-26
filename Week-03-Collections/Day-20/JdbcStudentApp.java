import java.sql.*;
import java.util.Scanner;

public class JdbcStudentApp {

    static final String url = "jdbc:mysql://localhost:3306/studentdb";
    static final String user = "root";
    static final String password = "root123";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            while (true) {

                System.out.println("\n=== JDBC Student Management ===");
                System.out.println("1. Add Student");
                System.out.println("2. Show All");
                System.out.println("3. Search by Roll");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");

                System.out.print("Enter choice: ");
                int ch = sc.nextInt();

                if (ch == 5) {
                    System.out.println("Bye!");
                    break;
                }

                switch (ch) {

                    case 1:
                        System.out.print("Roll: ");
                        int r = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Name: ");
                        String n = sc.nextLine();

                        System.out.print("Marks: ");
                        double m = sc.nextDouble();

                        String insert = "INSERT INTO students VALUES (?, ?, ?)";
                        PreparedStatement ps = con.prepareStatement(insert);
                        ps.setInt(1, r);
                        ps.setString(2, n);
                        ps.setDouble(3, m);

                        ps.executeUpdate();
                        System.out.println("Student added!");
                        break;

                    case 2:
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM students");

                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt("roll") + " | " +
                                    rs.getString("name") + " | " +
                                    rs.getDouble("marks"));
                        }
                        break;

                    case 3:
                        System.out.print("Enter roll: ");
                        int sr = sc.nextInt();

                        PreparedStatement search = con.prepareStatement(
                                "SELECT * FROM students WHERE roll = ?");
                        search.setInt(1, sr);

                        ResultSet rs2 = search.executeQuery();

                        if (rs2.next()) {
                            System.out.println(
                                    rs2.getInt("roll") + " | " +
                                    rs2.getString("name") + " | " +
                                    rs2.getDouble("marks"));
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter roll to delete: ");
                        int dr = sc.nextInt();

                        PreparedStatement del = con.prepareStatement(
                                "DELETE FROM students WHERE roll = ?");
                        del.setInt(1, dr);

                        int rows = del.executeUpdate();

                        if (rows > 0)
                            System.out.println("Deleted!");
                        else
                            System.out.println("Student not found.");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
