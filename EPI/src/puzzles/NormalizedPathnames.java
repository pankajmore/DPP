package puzzles;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Pankaj on 12/29/15.
 */
public class NormalizedPathnames {
    public static String shortestEquivalentPath(String path) {
        LinkedList<String> pathNames = new LinkedList<>();
        if (path.startsWith("/")) pathNames.push("/");
        for (String token : path.split("/")) {
            if (token.isEmpty() || token.equals(".")) continue;
            if (token.equals("..")) {
                if (pathNames.isEmpty() || pathNames.peek().equals("..")) pathNames.push(token);
                else {
                    if (pathNames.peek().equals("/")) throw new IllegalArgumentException("invalid path");
                    pathNames.pop();
                }
            } else {
                pathNames.push(token);
            }
        }
        StringBuilder sb = new StringBuilder();
        final Iterator<String> iter = pathNames.descendingIterator();
        String prev = iter.next();
        sb.append(prev);
        while (iter.hasNext()) {
            if (!prev.equals("/")) sb.append("/");
            prev = iter.next();
            sb.append(prev);
        }
        return sb.toString();
    }
}
