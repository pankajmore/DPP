import java.util.Stack;

/** https://leetcode.com/problems/reverse-words-in-a-string-iii/ Created by pankaj on 09/04/17. */
public class ReverseWordsInAStringIII {
  public String reverseWords(String s) {
    int N = s.length();
    StringBuilder sb = new StringBuilder(N);
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < N; i++) {
      char c = s.charAt(i);
      if (c == ' ') {
        while (!stack.isEmpty()) sb.append(stack.pop());
        sb.append(' ');
      } else {
        stack.push(c);
      }
    }
    while (!stack.isEmpty()) sb.append(stack.pop());
    return sb.toString();
  }
}
