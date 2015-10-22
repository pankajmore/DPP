package puzzles;

import org.junit.Test;

import java.util.Arrays;

import static puzzles.MostVisitedPages.Entry;

public class MostVisitedPagesTest {

    @Test
    public void sampleTest() {
        MostVisitedPages mvp = new MostVisitedPages();
        int timestamp = 0;
        assert mvp.common(10).isEmpty();
        mvp.add(new Entry("a", ++timestamp));
        mvp.add(new Entry("b", ++timestamp));
        mvp.add(new Entry("a", ++timestamp));
        mvp.add(new Entry("a", ++timestamp));
        mvp.add(new Entry("b", ++timestamp));
        mvp.add(new Entry("c", ++timestamp));
        mvp.add(new Entry("d", ++timestamp));
        assert mvp.common(4).equals(Arrays.asList("a", "b", "c", "d"));
        mvp.add(new Entry("b", ++timestamp));
        mvp.add(new Entry("b", ++timestamp));
        assert mvp.common(4).equals(Arrays.asList("b", "a", "c", "d"));
    }
}