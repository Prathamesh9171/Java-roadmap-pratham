public class Student {

    private int roll;
    private String name;
    private double marks;

    public Student(int roll, String name, double marks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }

    public int getRoll() {
        return roll;
    }

    public void display() {
        System.out.println(roll + " | " + name + " | " + marks);
    }
}
