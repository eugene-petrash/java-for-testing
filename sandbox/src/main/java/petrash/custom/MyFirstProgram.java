package petrash.custom;

public class MyFirstProgram {

    public static void main(String[] args) {
        hello("world");
        hello("user");
        hello("petrash");

        double side = 5.0;
        System.out.println("The aria of square with side " + side + " = " + aria(side));

        int a = 3;
        int b = 8;
        System.out.println("The aria of rectangle with sides " + a + " and " + b + " = " + aria(a, b));
    }

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody);
    }

    public static double aria(double side) {
        return side * side;
    }

    public static int aria(int sideA, int sideB) {
        return sideA * sideB;
    }
}
