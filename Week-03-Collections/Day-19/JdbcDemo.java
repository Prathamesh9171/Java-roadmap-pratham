import java.sql.*;

public class JdbcDemo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String password = "root123"; 

        try {

            
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("Connected to database!");

            String insertSql = "INSERT INTO students VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(insertSql);

            ps.setInt(1, 101);
            ps.setString(2, "Pratham");
            ps.setDouble(3, 88.5);

            ps.executeUpdate();

            System.out.println("Data inserted!");

            String selectSql = "SELECT * FROM students";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(selectSql);

            System.out.println("\n--- Students Table ---");

            while (rs.next()) {

                int roll = rs.getInt("roll");
                String name = rs.getString("name");
                double marks = rs.getDouble("marks");

                System.out.println(roll + " | " + name + " | " + marks);
            }

            con.close();

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}

