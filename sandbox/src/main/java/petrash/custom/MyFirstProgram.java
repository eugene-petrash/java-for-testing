package petrash.custom;

public class MyFirstProgram {

    public static void main(String[] args) {
        hello("world");
        hello("user");
        hello("petrash");

        Square s = new Square(5.0);
        System.out.println("The aria of square with side " + s.side + " = " + s.aria());

        Rectangle r = new Rectangle(3, 8);
        System.out.println("The aria of rectangle with sides " + r.sideA + " and " + r.sideB + " = " + r.aria());

        Point p1 = new Point(2, 3.6);
        Point p2 = new Point(18.56, 6.09);
        System.out.println("Distance between two points p1(x=" + p1.pointX + ", y=" + p1.pointY + "), " +
                "p2(x=" + p2.pointX + ", y=" + p2.pointY + ") equals " + p1.distance(p1, p2));
    }

    public static void hello(String somebody) {

        System.out.println("Hello, " + somebody);
    }

}
