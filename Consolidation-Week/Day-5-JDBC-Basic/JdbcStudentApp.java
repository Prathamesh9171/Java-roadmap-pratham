import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcStudentApp {

    static final String url = "jdbc:mysql://localhost:3306/studentdb";
    static final String user = "root";
    static final String password = "root123";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            while(true){
                System.out.println("\n=== JDBC Student mangement ===");
                System.out.println("1. Add Student ");
                System.out.println("2. Show All ");
                System.out.println("3. Exit ");

                System.out.print("Enter choice: ");
                int ch = sc.nextInt();

                if(ch == 3){
                    System.out.println("Bye !");
                    break;
                }
                switch (ch) {
                    case 1:
                        System.out.print("Enter roll: ");
                        int r = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String n = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        double m = sc.nextDouble();

                        String insert = "INSERT INTO students VALUES ( ?, ? , ?)";
                        PreparedStatement ps = con.prepareStatement(insert);
                        ps.setInt(1,r);
                        ps.setString(2,n);
                        ps.setDouble(3,m);

                        ps.executeUpdate();
                        System.out.println("Student added.");
                        break;
                    
                    case 2:
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM students");

                        while(rs.next()){
                            System.out.println(
                                rs.getInt("roll") + " | " + 
                                rs.getString("name") +" | " + 
                                rs.getDouble("marks")
                            );
                        }
                        
                        break;
                    
                    default:
                        System.out.println("Invalid choice. ");
                       
                }
            }
        } catch (SQLException e) {
           
           System.out.println("Error: " + e.getMessage());
        }
    }
}
