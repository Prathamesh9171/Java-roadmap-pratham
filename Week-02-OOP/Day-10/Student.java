public class Student extends Person {
    int roll;
    double marks;

    Student(int roll,String name,int age,double marks){
        super(name, age);
        this.roll = roll;
        this.marks = marks;
    }

    void displayStudent(){
        displayPerson();

        System.out.println("Roll: "+roll);
        System.out.println("Marks:"+marks);
        System.out.println("-------------------");
    }
}
