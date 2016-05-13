package puzzles;

import com.sun.istack.internal.NotNull;

/**
 * Created by Pankaj on 11/24/15.
 */
public class RabinKarp {
    public static final int kBase = 26, kMod = 997;

    public static int rabinKarp(@NotNull String t, @NotNull String s) {
        if (s.length() > t.length()) return -1;
        int tHash = 0, sHash = 0;
        int powerS = 1;
        for (int i = 0; i < s.length(); i++) {
            powerS = i == 0 ? 1 : powerS * kBase % kMod;
            tHash = (tHash * kBase + t.charAt(i)) % kMod;
            sHash = (sHash * kBase + s.charAt(i)) % kMod;
        }

        for (int i = s.length(); i < t.length(); i++) {
            if (tHash == sHash && t.substring(i - s.length(), i).equals(s)) return i - s.length();
            tHash -= (powerS * t.charAt(i - s.length())) % kMod;
            if (tHash < 0) tHash += kMod;
            tHash = (tHash * kBase + t.charAt(i)) % kMod;
        }
        if (tHash == sHash && t.substring(t.length() - s.length()).equals(s)) return t.length() - s.length();
        return -1;
    }
}
