import org.junit.Test;

/**
 * Created by pankaj on 2/22/16.
 */
public class RankTest {

    @Test
    public void testRank() throws Exception {
        assert Rank.rank("321") == 6;
        assert Rank.rank("aba") == 2;
        assert Rank.rank("dbba") == 12;
        assert Rank.rank("2412") == 8;
        assert Rank.rank("bbbbaaaa") == 70;
    }
}
