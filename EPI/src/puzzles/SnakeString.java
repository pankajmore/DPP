package puzzles;

import org.jetbrains.annotations.NotNull;

/**
 * Created by pankaj on 5/2/16.
 */
public class SnakeString {
    public static String snakeString(@NotNull String s) {
        int N = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i += 4) sb.append(s.charAt(i));
        for (int i = 0; i < N; i += 2) sb.append(s.charAt(i));
        for (int i = 3; i < N; i += 4) sb.append(s.charAt(i));
        return sb.toString();
    }
}
