import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainApp {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        
        list.add(new Student(3,"Rahul",78));
        list.add(new Student(1,"Pratham",85));
        list.add(new Student(2,"Amit",90));

        System.out.println("Before sorting:");
        for(Student s : list){
            s.display();
        }

        Collections.sort(list,new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s1.getMarks(),s2.getMarks());
            }
        });
        System.out.println("\nSorted by Marks(Ascending):");
        for(Student s: list ){
            s.display();
        }
        
        Collections.sort(list,new Comparator<Student>(){
            public int compare(Student s1,Student s2){
                return Double.compare(s2.getMarks(),s1.getMarks());
            }
        });

        System.out.println("\nSorted by marks(Descending):");
        for (Student s : list) {
            s.display();
        }

         Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });

        System.out.println("\nSorted by Name:");
        for (Student s : list) {
            s.display();
        }
    }
}
