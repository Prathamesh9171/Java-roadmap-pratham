public class Student {
    int roll ;
    String name;
    double marks;

    Student(int r,String n,double m){
        roll = r;
        name = n;
        marks = m;
    }

    void display(){
        System.out.println("Roll: " + roll);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("------------------");

    }
}
