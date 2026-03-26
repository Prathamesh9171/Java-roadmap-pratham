public class Student {
    int roll ;
    String name;
    double marks;

    Student(int roll,String name,double marks){
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }

   void display(){
    System.out.println(roll +" | "+name +" | "+marks);
    }
}
