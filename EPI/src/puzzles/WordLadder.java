package puzzles;

import java.util.*;

/** Created by pankaj on 2/5/16. */
public class WordLadder {
  public static List<List<String>> findLadders(
      String beginWord, String endWord, Set<String> wordList) {
    wordList.add(endWord);
    Map<String, Integer> lengthMap = new HashMap<>();
    Map<String, List<String>> parentMap = new HashMap<>();
    lengthMap.put(beginWord, 1);
    parentMap.put(beginWord, new ArrayList<>()); //root node
    bfs(beginWord, endWord, wordList, lengthMap, parentMap);
    return generateLadders(beginWord, endWord, parentMap);
  }

  private static void bfs(
      String beginWord,
      String endWord,
      Set<String> wordList,
      Map<String, Integer> lengthMap,
      Map<String, List<String>> parentMap) {
    Queue<String> q = new LinkedList<>();
    q.add(beginWord);
    while (!q.isEmpty()) {
      String s = q.remove();
      if (s.equals(endWord)) return;
      char[] chars = s.toCharArray();
      for (int i = 0; i < s.length(); i++) {
        for (char c = 'a'; c <= 'z'; c++) {
          char tmp = chars[i];
          chars[i] = c;
          String child = new String(chars);
          if (wordList.contains(child) && !lengthMap.containsKey(child)) { // first visit
            List<String> parents = new ArrayList<>();
            parents.add(s);
            lengthMap.put(child, lengthMap.get(s) + 1);
            parentMap.put(child, parents);
            q.add(child);
          } else if (wordList.contains(child)) {
            if (lengthMap.get(s) + 1 == lengthMap.get(child)) {
              List<String> parents = parentMap.get(child);
              parents.add(s);
              parentMap.put(child, parents);
            } // else condition has larger path
          }
          chars[i] = tmp;
        }
      }
    }
  }

  private static List<List<String>> generateLadders(
      String beginWord, String endWord, Map<String, List<String>> parentMap) {
    List<List<String>> ladders = new ArrayList<>();
    if (endWord.equals(beginWord)) {
      List<String> ladder = new ArrayList<>();
      ladder.add(beginWord);
      ladders.add(ladder);
      return ladders;
    }
    for (String parent : parentMap.get(endWord)) {
      ladders.addAll(generateLadders(beginWord, parent, parentMap));
    }
    for (List<String> ladder : ladders) ladder.add(endWord);
    return ladders;
  }

  public static void main(String[] args) {
    String beginWord = "hit";
    String endWord = "cog";
    Set<String> wordList = new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
    List<List<String>> ladders = findLadders(beginWord, endWord, wordList);
    System.out.println(ladders.toString());
  }
}
