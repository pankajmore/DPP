import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by pankaj on 9/2/16.
 */
public class SqrtXTest {
    @Test
    public void testMySqrt() throws Exception {
        for (int i = 0; i >= 0; i++) {
            int expected = (int) Math.sqrt(i);
            Assert.assertEquals(expected, SqrtX.mySqrt(i));
            Assert.assertEquals(expected, SqrtX.mySqrt1(i));
        }
    }
}