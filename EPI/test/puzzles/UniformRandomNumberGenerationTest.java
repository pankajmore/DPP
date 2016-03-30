package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Created by pankaj on 3/30/16.
 */
@RunWith(Theories.class)
public class UniformRandomNumberGenerationTest {

    @Theory
    public void uniformRandom(@ForAll @InRange(minInt = 0) int a,
                              @ForAll @InRange(minInt = 0) int b) throws Exception {
        if (a > b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }

        try {
            int r = UniformRandomNumberGeneration.uniformRandom(a, b);
            assert r >= a && r < b;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assert a == b || b - a > 1 << 31;
        }
    }
}