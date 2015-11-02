package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.io.*;
import java.util.Collections;
import java.util.List;

import static puzzles.SearchMajority.checkIfMajority;
import static puzzles.SearchMajority.majoritySearch;

@RunWith(Theories.class)
public class SearchMajorityTest {

    @Theory
    public void testMajoritySearch(@ForAll List<String> ls) throws IOException {
        int N = ls.size();
        if (N == 0) return;
        for (int i = 0; i <= N; i++) ls.add(ls.get(0));
        Collections.shuffle(ls);
        InputStream sin;
        ByteArrayOutputStream sout = new ByteArrayOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(sout);
        for (String s : ls) osw.write(s + "\n");
        osw.close();
        sin = new ByteArrayInputStream(sout.toByteArray());
        String expected = majoritySearch(sin);
        sin.reset();
        assert checkIfMajority(sin, expected);
    }
}