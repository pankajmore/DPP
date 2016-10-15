import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/fizz-buzz/
 * Created by pankaj on 10/15/16.
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> ls = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean threes = i % 3 == 0;
            boolean fives = i % 5 == 0;
            if (threes && fives) {
                ls.add("FizzBuzz");
            } else if (threes) {
                ls.add("Fizz");
            } else if (fives) {
                ls.add("Buzz");
            } else {
                ls.add(String.valueOf(i));
            }
        }
        return ls;
    }
}
