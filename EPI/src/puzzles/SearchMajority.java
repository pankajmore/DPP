package puzzles;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Pankaj on 11/1/15.
 */
public class SearchMajority {
    public static String majoritySearch(InputStream sin) {
        String candidate = "";
        Scanner in = new Scanner(sin);
        int count = 0;
        while (in.hasNextLine()) {
            if (count == 0) {
                candidate = in.nextLine();
                count++;
            } else {
                if (candidate.equals(in.nextLine())) count++;
                else count--;
            }
        }
        return candidate;
    }

    public static boolean checkIfMajority(InputStream sin, String ans) {
        int count = 0, N = 0;
        Scanner in = new Scanner(sin);
        while (in.hasNextLine()) {
            if (in.nextLine().equals(ans)) count++;
            N++;
        }
        return count > N / 2;
    }
}
