package pramp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pankaj on 8/15/16.
 */
public class FlattenMap {
    public static Map<String, String> flatten(Map<String, Object> map) {
        Map<String, String> flatMap = new HashMap<>();
        recurseFlatten(map, new StringBuilder(), flatMap);
        return flatMap;
    }

    private static void recurseFlatten(Map<String, Object> map, StringBuilder keySoFar, Map<String, String> flatMap) {
        for (String key : map.keySet()) {
            int lastKeyIndex = keySoFar.length();
            if (keySoFar.length() == 0)
                keySoFar.append(key);
            else
                keySoFar.append(".").append(key);

            Object val = map.get(key);
            if (val instanceof Map) {
                recurseFlatten((Map<String, Object>) val, keySoFar, flatMap);
            } else if (val instanceof String) {
                flatMap.put(keySoFar.toString(), (String) val);
            } else {
                throw new IllegalArgumentException("unexpected input : " + map.toString());
            }
            keySoFar.delete(lastKeyIndex, keySoFar.length());
        }
    }
}
