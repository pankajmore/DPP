import java.util.Stack;

/** https://leetcode.com/problems/decode-string/ Created by pankaj on 9/6/16. */
class DecodeString {
  String decodeString(String s) {
    String res = "";
    Stack<String> stack = new Stack<>();
    Stack<Integer> count = new Stack<>();
    int i = 0, N = s.length();
    while (i < N) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        int d = 0;
        while (Character.isDigit(s.charAt(i))) {
          d = d * 10 + s.charAt(i) - '0';
          i++;
        }
        count.push(d);
      } else if (c == '[') {
        stack.push(res);
        res = "";
        i++;
      } else if (c == ']') {
        StringBuilder tmp = new StringBuilder(stack.pop());
        int d = count.pop();
        while (d-- > 0) tmp.append(res);
        res = tmp.toString();
        i++;
      } else {
        res += c;
        i++;
      }
    }
    return res;
  }
}
