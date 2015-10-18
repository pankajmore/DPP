package puzzles;

import org.junit.Test;

import static puzzles.NearestRepetition.findNearestRepetition;

public class NearestRepetitionTest {

    @Test
    public void testFindNearestRepetition() throws Exception {
        String[] A =
                new String[]{"foo", "bar", "widget", "foo", "widget", "widget", "adnan"};
        assert (checkAnswer(A) == findNearestRepetition(A));
        A = new String[]{"foo", "bar", "widget", "foo",
                "xyz", "widget", "bar", "adnan"};
        assert (checkAnswer(A) == findNearestRepetition(A));
        A = new String[]{"foo", "bar", "widget", "adnan"};
        assert (checkAnswer(A) == findNearestRepetition(A));
        A = new String[]{};
        assert (checkAnswer(A) == findNearestRepetition(A));
        A = new String[]{"foo", "foo", "foo"};
        assert (checkAnswer(A) == findNearestRepetition(A));
    }

    private int checkAnswer(String[] paragraph) {
        int nearestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < paragraph.length; i++) {
            for (int j = i + 1; j < paragraph.length; j++) {
                if (paragraph[i].equals(paragraph[j]))
                    nearestDistance = Math.min(nearestDistance, j - i);
            }
        }
        return nearestDistance;
    }
}