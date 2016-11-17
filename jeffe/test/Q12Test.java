import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pankaj on 17/11/16.
 */
public class Q12Test {
    @Test
    public void isShuffle() throws Exception {
        Assert.assertTrue(Q12.isShuffle("", "", ""));
        Assert.assertTrue(Q12.isShuffle("", "A", "A"));
        Assert.assertTrue(Q12.isShuffle("A", "", "A"));
        Assert.assertTrue(Q12.isShuffle("A", "B", "AB"));
        Assert.assertTrue(Q12.isShuffle("B", "A", "AB"));
        Assert.assertTrue(Q12.isShuffle("A", "BC", "ABC"));
        Assert.assertTrue(Q12.isShuffle("AB", "C", "ABC"));
        Assert.assertTrue(Q12.isShuffle("AC", "B", "ABC"));
        Assert.assertTrue(Q12.isShuffle("ABC", "", "ABC"));
        Assert.assertTrue(Q12.isShuffle("BANANA", "ANANAS", "BANANAANANAS"));
    }

}