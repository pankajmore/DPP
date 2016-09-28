/**
 * https://leetcode.com/problems/reverse-string/
 * Created by pankaj on 9/28/16.
 */
public class ReverseString {
    public String reverseString(String s) {
        char[] a = s.toCharArray();
        int N = a.length;
        for (int i = 0; i < N / 2; i++) {
            char tmp = a[i];
            a[i] = a[N - 1 - i];
            a[N - 1 - i] = tmp;
        }
        return new String(a);
    }
}
