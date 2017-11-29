package petrash.custom;

/**
 * Created by petrash on 11/29/17.
 */
public class Square {

    public double side;

    public Square(double side) {
        this.side = side;
    }

    public double aria() {
        return this.side * this.side;
    }
}
