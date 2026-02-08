import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> list = new ArrayList<>();

    // Method 1
    public void addStudent(Student s) {
        list.add(s);
        System.out.println("Student added!");
    }

    // Method 2
    public void showAll() {

        if (list.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : list) {
            s.display();
        }
    }

    // Method 3 (SEARCH)  <-- Must be OUTSIDE showAll
    public void searchByRoll(int roll) {

        for (Student s : list) {

            if (s.getRoll() == roll) {
                System.out.println("Student Found:");
                s.display();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Method 4 (DELETE)  <-- Must be OUTSIDE showAll
    public void deleteByRoll(int roll) {

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getRoll() == roll) {

                list.remove(i);
                System.out.println("Student deleted.");
                return;
            }
        }

        System.out.println("Student not found.");
    }
}
