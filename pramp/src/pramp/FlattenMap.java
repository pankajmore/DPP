package pramp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pankaj on 8/15/16.
 */
public class FlattenMap {
    public static Map<String, String> flatten(Map<String, Object> map) {
        Map<String, String> flatMap = new HashMap<>();
        recurseFlatten(map, "", flatMap);
        return flatMap;
    }

    private static void recurseFlatten(Map<String, Object> map, String keySoFar, Map<String, String> flatMap) {
        for (String key : map.keySet()) {
            String newKey = keySoFar.isEmpty() ? key : keySoFar.concat(".").concat(key);
            if (map.get(key) instanceof String) {
                flatMap.put(newKey, (String) map.get(key));
            } else {
                assert map.get(key) instanceof Map;
                recurseFlatten((Map<String, Object>) map.get(key), newKey, flatMap);
            }
        }
    }
}
