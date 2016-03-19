package puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankaj on 3/19/16.
 */
public class GenerateParentheses {
    public static List<String> generateBalancedParentheses(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) return list;
        StringBuilder sb = new StringBuilder();
        generateParenthesesHelper(0, 0, n, sb, list);
        return list;
    }

    private static void generateParenthesesHelper(int open, int close, int n, StringBuilder sb, List<String> list) {
        if (close > open || open > n) return;
        if (open == close && open == n) {
            list.add(sb.toString());
        } else {
            sb.append('(');
            generateParenthesesHelper(open + 1, close, n, sb, list);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(')');
            generateParenthesesHelper(open, close + 1, n, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
