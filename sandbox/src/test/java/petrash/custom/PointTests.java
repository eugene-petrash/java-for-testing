package petrash.custom;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by petrash on 12/10/17.
 */
public class PointTests {

    @Test
    public void testDistance() {
        Point point1 = new Point(24.0, 67.09);
        Point point2 = new Point(0.35, 19.8);

        Assert.assertEquals(point1.distance(point1, point2), 52.87406358508868);
    }
}
