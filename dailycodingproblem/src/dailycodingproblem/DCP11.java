package dailycodingproblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Implement an autocomplete system. That is, given a query string s and a dictionary of all
 * possible query strings, return all strings in the dictionary that have s as a prefix.
 */
class DCP11 {
  static Trie triefy(Set<String> dict) {
    Trie t = new Trie();
    for (String s : dict) {
      t.add(s);
    }
    return t;
  }

  static Set<String> prefixSearch(String s, Trie dict) {
    return dict.prefix(s).toList(s);
  }

  static class Trie {
    Map<Character, Trie> children;

    Trie() {
      children = new HashMap<>();
    }

    void add(String s) {
      char[] chars = s.toCharArray();
      Trie curr = this;
      for (char c : chars) {
        curr.children.putIfAbsent(c, new Trie());
        curr = curr.children.get(c);
      }
      curr.children.put('\n', new Trie());
    }

    Trie prefix(String s) {
      char[] chars = s.toCharArray();
      Trie curr = this;
      for (char c : chars) {
        if (curr == null) {
          return null;
        } else {
          curr = curr.children.get(c);
        }
      }
      return curr;
    }

    Set<String> toList(String prefix) {
      Set<String> set = new HashSet<>();
      StringBuilder sb = new StringBuilder().append(prefix);
      toListInternal(set, sb);
      return set;
    }

    void toListInternal(Set<String> list, StringBuilder sb) {
      if (children.isEmpty()) {
        list.add(sb.toString());
      }
      for (char c : children.keySet()) {
        if (c != '\n') sb.append(c);
        children.get(c).toListInternal(list, sb);
        if (c != '\n') sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
}
