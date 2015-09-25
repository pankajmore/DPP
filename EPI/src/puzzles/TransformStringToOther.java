package puzzles;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Pankaj on 9/25/15.
 */
public class TransformStringToOther {
    public static int shortestProductionSequence(String s, String t, Set<String> D) {
        Set<String> visited = new HashSet<>();
        Map<String, Integer> distance = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        if (s.length() != t.length()) return -1;
        if (!D.contains(s) || !D.contains(t)) return -1;
        q.add(s);
        distance.put(s, 1);
        while (!q.isEmpty()) {
            String n = q.poll();
            visited.add(n);
            if (n.equals(t)) return distance.get(n);
            for (String child : children(n, D)) {
                if (!visited.contains(child)) {
                    q.add(child);
                    distance.put(child, distance.get(n) + 1);
                }
            }
        }
        return -1;
    }

    private static List<String> children(String n, Set<String> D) {
        return D.stream().filter((String x) -> differs(x, n) == 1).collect(Collectors.toList());
    }

    private static int differs(String x, String y) {
        if (x.length() != y.length()) return -1;
        int c = 0;
        for (int i = 0; i < x.length(); i++) if (x.charAt(i) != y.charAt(i)) c++;
        return c;
    }
}
