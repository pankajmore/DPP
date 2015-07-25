package puzzles;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Pankaj on 7/25/15.
 */
public class LRUCache {
    public static long CACHE_SIZE = 100;
    public static Map<String, Double> _cache = new HashMap<>();

    /**
     * First returns the price of the book from the cache
     * If not present in cache, it goes and loads it from the disk
     *
     * @param key The ISBN string for a given key
     * @return The dollar price of the book
     */
    //TODO: make the cache bounded
    //TODO: implement LRU cache eviction policy
    public static double get(String key) {
        if (!_cache.containsKey(key))
            _cache.put(key, readFromDisk(key));
        return _cache.get(key);
    }

    /**
     * Simulates reading from disk by just generating a random price instead.
     *
     * @param key
     * @return
     */
    private static double readFromDisk(String key) {
        return new Random().nextDouble();
    }
}
