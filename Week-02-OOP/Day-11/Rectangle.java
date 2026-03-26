public class Rectangle extends Shape {

    double length, width;

    Rectangle(double l, double w) {
        length = l;
        width = w;
    }

    @Override
    void area() {
        System.out.println("Area of Rectangle = " + (length * width));
    }
}
