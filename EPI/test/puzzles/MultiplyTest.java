package puzzles;

import org.junit.Assert;
import org.junit.Test;

import static puzzles.Multiply.multiply;

/**
 * Created by pankaj on 2/12/16.
 */
public class MultiplyTest {

    @Test
    public void testMultiply() throws Exception {
        Assert.assertEquals(1, multiply(1, 1));
        Assert.assertEquals(12, multiply(3, 4));
        Assert.assertEquals(65535 * 65535, multiply(65535, 65535));
    }
}