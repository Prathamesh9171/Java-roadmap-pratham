import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortDemo {
    public static void main(String[] args) {
        ArrayList<Student> list =new ArrayList<>();
        list.add(new Student(1,"Pratham", 85.0));
        list.add(new Student(2,"Amit", 71.0));
        list.add(new Student(3,"Vishal", 78.0));

        System.out.println("Before sorting:");
        for(Student s : list){
            s.display();
        }

         Collections.sort(list, new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s1.marks, s2.marks);
            }
        });

        System.out.println("\nAfter Sorting by Marks:");
        for (Student s : list) {
            s.display();
        }

        Collections.sort(list, new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {
                return s1.name.compareTo(s2.name);
            }
        });

        System.out.println("\nAfter Sorting by Name:");
        for (Student s : list) {
            s.display();
        }

    }
}
