public class MainApp {
    public static void main(String[] args) {
        Student s1 = new Student(1,"Pratham ", 20, 85);
        Student s2 = new Student(2, "rahul", 21, 78);
        Student s3 = new Student(3,"Amit" , 21, 80);

        s1.displayStudent();
        s2.displayStudent();
        s3.displayStudent();
    }
}
