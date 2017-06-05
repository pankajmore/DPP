import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/** https://leetcode.com/problems/find-duplicate-file-in-system/ Created by pankaj on 05/06/17. */
class FindDuplicateFileInSystem {
  List<List<String>> findDuplicate(final String[] paths) {
    HashMap<String, List<String>> contentToFileMap = new HashMap<>();
    for (String path : paths) {
      String[] ls = path.split(" ");
      String dirPath = ls[0];
      for (int i = 1; i < ls.length; i++) {
        String fileAndContent = ls[i];
        int idx = fileAndContent.indexOf('(');
        String file = fileAndContent.substring(0, idx);
        String content = fileAndContent.substring(idx + 1, fileAndContent.length() - 1);
        contentToFileMap.putIfAbsent(content, new ArrayList<>());
        contentToFileMap.get(content).add(dirPath + "/" + file);
      }
    }
    return contentToFileMap
        .values()
        .stream()
        .filter(l -> l.size() > 1)
        .collect(Collectors.toList());
  }
}
