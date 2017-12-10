package petrash.custom;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by petrash on 12/10/17.
 */
public class SquareTests {

    @Test
    public void testAria() {
        Square square = new Square(7.0);
        Assert.assertEquals(square.aria(), 49.0);
    }
}
