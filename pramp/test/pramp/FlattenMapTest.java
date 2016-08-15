package pramp;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static pramp.FlattenMap.flatten;

/**
 * Created by pankaj on 8/15/16.
 */
public class FlattenMapTest {
    @Test
    public void testFlatten() throws Exception {
        Map<String, Object> nestedMap = new HashMap<>();
        nestedMap.put("a", "1");
        Map<String, Object> map1 = new HashMap<>();
        map1.put("c", "2");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("e", "3");
        map1.put("d", map2);
        nestedMap.put("b", map1);
        final Map<String, String> flatMap = flatten(nestedMap);
        System.out.println(flatMap.toString());
        Assert.assertEquals(flatMap.get("a"), "1");
        Assert.assertEquals(flatMap.get("b.c"), "2");
        Assert.assertEquals(flatMap.get("b.d.e"), "3");
    }
}