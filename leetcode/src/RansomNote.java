/**
 * https://leetcode.com/problems/ransom-note/
 * Created by pankaj on 9/10/16.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int a[] = new int[26];
        for (char c : magazine.toCharArray()) a[c - 'a']++;
        for (char c : ransomNote.toCharArray()) a[c - 'a']--;
        for (int i = 0; i < 26; i++) if (a[i] < 0) return false;
        return true;
    }
}
