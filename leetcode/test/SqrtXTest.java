import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by pankaj on 9/2/16.
 */
public class SqrtXTest {
    @Test
    public void testMySqrt() throws Exception {
        for (int i = 0; i <= Integer.MAX_VALUE; i++)
            Assert.assertEquals((int) Math.sqrt(i), SqrtX.mySqrt(i));
    }
}