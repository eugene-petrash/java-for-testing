package petrash.custom;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by petrash on 12/10/17.
 */
public class RectangleTests {

    @Test
    public void testAria() {
        Rectangle rectangle = new Rectangle(44, 16);
        Assert.assertEquals(rectangle.aria(), 704);
    }
}
