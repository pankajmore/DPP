package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static puzzles.KClosestStars.Star;
import static puzzles.KClosestStars.kClosestStars;

@RunWith(Theories.class)
public class KClosestStarsTest {

    @Test
    public void testKClosestStars() throws Exception {

    }

    @Test
    public void testKSmallest() throws Exception {

    }

    //TODO: fix the generator for Star
    //TODO: report the issue to the github tracker
    @Theory
    public void kSmallestFromSorted(@ForAll @From(StarGenerator.class) List<KClosestStars.Star> ls) {
        for (int k = 0; k <= ls.size(); k++) {
            List<KClosestStars.Star> ans = kClosestStars(ls, k);
            Collections.sort(ls);
            assertEquals(ls.subList(0, k), ans);
        }
    }

    /**
     * Created by Pankaj on 7/13/15.
     */
    public static class StarGenerator extends Generator<List<Star>> {

        @SuppressWarnings("unchecked")
        public StarGenerator() {
            super(asList((Class<List<Star>>) (Object) List.class));
        }

        @Override
        public List<Star> generate(SourceOfRandomness random, GenerationStatus status) {
            int size = random.nextInt(0, 10 ^ 6);
            List<Star> stars = new ArrayList<Star>();
            for (int i = 0; i < size; i++)
                stars.add(new Star(random.nextLong(), random.nextDouble(), random.nextDouble(), random.nextDouble()));
            return stars;
        }
    }
}
