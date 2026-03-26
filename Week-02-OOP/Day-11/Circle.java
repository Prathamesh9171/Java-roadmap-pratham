public class Circle extends Shape {

    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void area() {
        double result = 3.14 * radius * radius;
        System.out.println("Area of Circle = " + result);
    }
}
