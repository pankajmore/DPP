package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import static java.lang.Math.abs;
import static org.junit.Assert.assertEquals;

@RunWith(Theories.class)
public class IntegerSquareRootTest {
    @Theory
    public void compareWithTrivial(@ForAll int k){
        k = abs(k);
        int ans = IntegerSquareRoot.integerSquareRoot(k);
        assertEquals(ans, bruteForceIntegerSquareRoot(k));
        assertEquals(ans, ((int) Math.floor(Math.sqrt(k))));
    }

    public int bruteForceIntegerSquareRoot(int k)
    {
        int ans = 0;
        for(int i=0;i<k;i++){
            if(i*i<=k)
                ans = i;
            else break;
        }
        return ans;
    }
}