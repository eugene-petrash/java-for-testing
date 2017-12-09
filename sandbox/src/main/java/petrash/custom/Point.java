package petrash.custom;

/**
 * Created by petrash on 12/9/17.
 */
public class Point {

    public double pointX;
    public double pointY;

    public Point(double x, double y) {
        this.pointX = x;
        this.pointY = y;
    }

    public double distance(Point p1, Point p2) {

        return Math.sqrt(
                Math.pow(p1.pointX - p2.pointX, 2) +
                        Math.pow(p1.pointY - p2.pointY, 2)
        );
    }
}
