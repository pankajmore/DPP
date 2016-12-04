/**
 * #434
 * Created by pankaj on 04/12/16.
 */
public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        String[] words = s.split("\\s+");
        return words.length == 0 ? 0 : words[0].isEmpty() ? words.length - 1 : words.length;
    }
}
