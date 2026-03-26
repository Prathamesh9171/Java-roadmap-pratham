public class MainApp {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.roll = 1;
        s1.name ="Pratham";
        s1.marks = 85.5;

        Student s2 = new Student();
        s2.roll = 2;
        s2.name ="Rahul";
        s2.marks = 78.0;

        Student s3 = new Student();
        s3.roll = 3;
        s3.name ="Himanshu";
        s3.marks = 65.0;

        s1.display();
        s2.display();
        s3.display();

    }
}
