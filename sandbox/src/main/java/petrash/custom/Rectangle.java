package petrash.custom;

/**
 * Created by petrash on 11/29/17.
 */
public class Rectangle {

    public int sideA;
    public int sideB;

    public Rectangle(int a, int b) {
        this.sideA = a;
        this.sideB = b;
    }

    public int aria() {
        return this.sideA * this.sideB;
    }
}
