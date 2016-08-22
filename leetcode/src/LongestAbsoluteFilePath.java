import java.util.Stack;

/**
 * https://leetcode.com/contest/1/problems/longest-absolute-file-path/
 * Created by pankaj on 8/21/16.
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        int N = input.length();
        int longestPath = 0;
        Stack<Integer> s = new Stack<>();
        int prevTab, currTab = 0, count = 0;
        boolean isFile = false;
        for (int i = 0; i < N; i++) {
            char c = input.charAt(i);
            if (c == '\n') {
                if (isFile) {
                    longestPath = Math.max(longestPath, (s.empty() ? 0 : s.peek()) + count);
                    isFile = false;
                    prevTab = currTab == 0 ? 0 : currTab - 1;
                } else {
                    s.push((s.isEmpty() ? 0 : s.peek()) + count + 1);
                    prevTab = currTab;
                }
                count = 0;
                currTab = 0;
                while (i + 1 < N && input.charAt(i + 1) == '\t') {
                    i++;
                    currTab++;
                }
                assert currTab - prevTab <= 1;
                for (int j = 0; j <= prevTab - currTab; j++) s.pop();
            } else {
                if (c == '.') isFile = true;
                count++;
            }
        }
        if (isFile) longestPath = Math.max(longestPath, (s.isEmpty() ? 0 : s.peek()) + count);
        return longestPath;
    }
}