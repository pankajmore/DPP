package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static puzzles.JustifyText.justifyText;

/** Created by pankaj on 2/29/16. */
public class JustifyTextTest {

  private static void testCase(String[] words, int L, String[] golden) {
    List<String> result = justifyText(words, L);
    for (String s : result) {
      System.out.println("\"" + s + "\"");
    }
    System.out.println();
    assert (Arrays.equals(result.toArray(), golden));
  }

  @Test
  public void testJustify() throws Exception {
    String words[] =
        new String[] {"Text", "justification", "is", "trickier", "than", "it", "seems!"};
    String golden[] =
        new String[] {"Text          ", "justification ", "is    trickier", "than it seems!"};
    int L = 14;
    System.out.println("L = " + L);
    testCase(words, L, golden);
    words = new String[] {"Listen", "to", "many,", "speak", "to", "a", "few."};
    golden = new String[] {"Listen", "to    ", "many, ", "speak ", "to   a", "few.  "};
    L = 6;
    System.out.println("L = " + L);
    testCase(words, L, golden);
    words = new String[] {"The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dogs."};
    golden =
        new String[] {"The   quick", "brown   fox", "jumped over", "the    lazy", "dogs.      "};
    L = 11;
    System.out.println("L = " + L);
    testCase(words, L, golden);
    golden = new String[] {"The  quick brown", "fox  jumped over", "the lazy dogs.  "};
    L = 16;
    System.out.println("L = " + L);
    testCase(words, L, golden);
    golden = new String[] {"The  quick  brown", "fox  jumped  over", "the lazy dogs.   "};
    L = 17;
    System.out.println("L = " + L);
    testCase(words, L, golden);
    words = new String[] {"Hello", "World"};
    golden = new String[] {"Hello World   "};
    L = 14;
    System.out.println("L = " + L);
    testCase(words, L, golden);
  }
}
