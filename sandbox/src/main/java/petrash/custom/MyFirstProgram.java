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
    }

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody);
    }

}
